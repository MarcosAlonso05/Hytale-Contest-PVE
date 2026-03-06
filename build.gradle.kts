/**
 * NOTE: This is entirely optional and basics can be done in `settings.gradle.kts`
 */

repositories {
    // Any external repositories besides: MavenLocal, MavenCentral, HytaleMaven, and CurseMaven
}

dependencies {
    // Any external dependency you also want to include
}

val hytaleHome: String? = project.findProperty("hytale.home_path") as String?

dependencies {
    if (hytaleHome != null) {
        val assetsZip = file("$hytaleHome/install/release/package/game/latest/Assets.zip")

        if (assetsZip.exists()) {
            implementation(files(assetsZip))

        } else {
            logger.warn("Assets.zip not found in: ${assetsZip.absolutePath}")
        }
    } else {
        logger.warn("hytaleHome path not defined")
    }
}