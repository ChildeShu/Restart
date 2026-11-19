plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.2.1"
}

group = "com.childeshu"
version = "1.0.0"

repositories {
    maven { url = uri("https://maven.aliyun.com/repository/public") }
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaCommunity("2024.1.4", useInstaller = false)
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

intellijPlatform {
    pluginConfiguration {
        name = "Restart"
        version = project.version.toString()
        vendor {
            name = "锦舒"
            email = "jiansite@qq.com"
            url = "https://user.qzone.qq.com/1340582309/infocenter"
        }
        ideaVersion {
            sinceBuild = "231"
            untilBuild = "243.*"
        }
    }
    // 插件没有自定义设置项，跳过 searchable options 任务，
    // 避免无头 IDE 启动失败 / 产生 "No searchable options found" 告警
    buildSearchableOptions = false
    // 发布到 JetBrains Marketplace：
    // token 通过 -PintellijPlatformPublishingToken=xxx 或环境变量
    // ORG_GRADLE_PROJECT_intellijPlatformPublishingToken 注入
    publishing {
        token = providers.gradleProperty("intellijPlatformPublishingToken")
        channels = listOf("default")
    }
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
    buildPlugin {
        archiveBaseName = "Restar"
    }
}
