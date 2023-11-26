// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
//    repositories {
//        google()
//        mavenCentral()
//    }
    dependencies {
        classpath ("com.android.application:com.android.application.gradle.plugin:7.2.2")
        classpath ("com.google.gms:google-services:4.3.15")
    }
}
plugins {
    id ("com.android.application") version "7.4.1" apply false
    id ("com.android.library") version "7.4.1" apply false
}