plugins {
    kotlin("jvm") version "1.9.23"
    alias(libs.plugins.sonatypeCentralPortalPublisher)
}

group = "world.avionik"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(kotlin("stdlib"))

    // adventure dependencies
    val adventureVersion = "4.15.0"
    compileOnly("net.kyori:adventure-api:$adventureVersion")
    compileOnly("net.kyori:adventure-text-minimessage:$adventureVersion")
    compileOnly("net.kyori:adventure-text-serializer-gson:$adventureVersion")
}

signing {
    useGpgCmd()
    sign(publishing.publications)
}

centralPortal {
    username = project.findProperty("sonatypeUsername") as String
    password = project.findProperty("sonatypePassword") as String

    pom {
        name.set("Minecraft Common")
        description.set("Small extensions for Minecraft projects")
        url.set("https://github.com/avionik-world/minecraft-common")

        developers {
            developer {
                id.set("niklasnieberler")
                email.set("admin@avionik.world")
            }
        }
        licenses {
            license {
                name.set("Apache-2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        scm {
            url.set("https://github.com/avionik-world/minecraft-common.git")
            connection.set("git:git@github.com:avionik-world/minecraft-common.git")
        }
    }
}