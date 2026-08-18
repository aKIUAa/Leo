# AYE — Library Decisions

Why each dependency is here, so nobody has to guess later.

## Locked

**LWJGL 3.4.2** — not really a choice. Minecraft: Java Edition's client jar
imports `org.lwjgl.*` directly, so every launcher needs an LWJGL-API-compatible
layer, no way around it. We pull stock upstream LWJGL for the Java classes —
NOT a pre-patched fork like Pojav/Amethyst/Mojo's custom "lwjgl3-build" repos.
⚠️ This only brings in the Java API. The native `.so` binaries LWJGL calls into
are built for desktop OSes, not Android — every launcher we studied maintains
its own Android-native LWJGL build for exactly this reason. That's real,
separate work for later (CREDITS/LEI territory), tracked in BACKLOG.md.

**OkHttp 5.4.0** — handles everything MOJANG needs to talk to: auth, version
manifest, asset index, library downloads. Proven on Android, handles pooling
and retries so we don't hand-roll that.

**kotlinx-coroutines 1.10.2** — every network call above needs to run off the
main thread cleanly. Standard for Kotlin-first Android work.

## Deliberately not here yet

- **kotlinx.serialization** — the right call for parsing Mojang's JSON (version
  manifests, auth payloads), but its compiler plugin version has to match
  whatever Kotlin compiler AGP 9.3.0 bundles internally via built-in Kotlin
  support — and that's *not* the same thing as any Kotlin version we'd pick
  ourselves. Mismatches here are a known live pain point in the Kotlin/AGP
  community right now, not just us being cautious. One thing needed from you:
  next time you open the project in Android Studio, Project Structure will
  show the exact bundled Kotlin version — tell me that number and this gets
  added correctly on the first try instead of guessing.
- **Android-native JVM/JRE port** — Pojav, Amethyst, and Mojo all vendor a
  custom-built OpenJDK for Android via CI, not a Maven dependency. Same deal
  here eventually. Belongs to CREDITS.
- **Renderer / GL translation layer** — this is LEI's whole reason to exist.
  Not touched here.

## What we're not doing
Not forking anyone's pre-patched LWJGL, GL4ES, or Mesa build. Stock upstream
where stock works (LWJGL API, OkHttp, kotlinx-coroutines), original build
where it doesn't (native LWJGL, JVM port, renderer).
