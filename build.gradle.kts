plugins {
    id("java-library")
    id("net.labymod.gradle")
    id("net.labymod.gradle.addon")
}

group = "top.einsluca"
version = "1.0.0"

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

labyMod {
    defaultPackageName = "top.einsluca.autogg" //change this to your main package name (used by all modules)
    addonInfo {
        namespace = "auto-gg"
        displayName = "AutoGG"
        author = "EinsLuca"
        description = "Make yourself more likeable by automatically writing a GG in the chat after each round."
        minecraftVersion = "*"
        version = System.getenv().getOrDefault("VERSION", "1.0.0")
    }

    minecraft {
        registerVersions(
                "1.18.2",
                "1.19.2",
                "1.19.3",
                "1.19.4",
                "1.20.1"
        ) { version, provider ->
            configureRun(provider, version)
        }

        subprojects.forEach {
            if (it.name != "game-runner") {
                filter(it.name)
            }
        }
    }

    addonDev {
        productionRelease()
    }
}

subprojects {
    plugins.apply("java-library")
    plugins.apply("net.labymod.gradle")
    plugins.apply("net.labymod.gradle.addon")

    repositories {
        maven("https://libraries.minecraft.net/")
        maven("https://repo.spongepowered.org/repository/maven-public/")
    }
}

fun configureRun(provider: net.labymod.gradle.core.minecraft.provider.VersionProvider, gameVersion: String) {
    provider.runConfiguration {
        mainClass = "net.minecraft.launchwrapper.Launch"
        jvmArgs("-Dnet.labymod.running-version=${gameVersion}")
        jvmArgs("-Dmixin.debug=true")
        jvmArgs("-Dnet.labymod.debugging.all=true")
        jvmArgs("-Dmixin.env.disableRefMap=true")

        args("--tweakClass", "net.labymod.core.loader.vanilla.launchwrapper.LabyModLaunchWrapperTweaker")
        args("--labymod-dev-environment", "true")
        args("--addon-dev-environment", "true")
    }

    provider.javaVersion = when (gameVersion) {
        else -> {
            JavaVersion.VERSION_17
        }
    }

    provider.mixin {
        val mixinMinVersion = when (gameVersion) {
            "1.8.9", "1.12.2", "1.16.5" -> {
                "0.6.6"
            }

            else -> {
                "0.8.2"
            }
        }

        minVersion = mixinMinVersion
    }
}
