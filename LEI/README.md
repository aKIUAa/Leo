# LEI

Leo's own renderer — the reason Leo exists as a separate project.

Every existing Java-on-Android launcher renders through the same inherited stack: GL4ES translating GLES calls to desktop GL, LWJGLX bridging old mod code onto LWJGL3, with Zink/ANGLE/VirGL/MobileGlues swapped in as alternate renderers. LEI isn't another option bolted onto that stack — it's built independently of it.

Design and implementation happen here once planning is done.
