package com.cognifide.gradle.aem

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.BasePlugin

/**
 * Provides configuration used by both package and instance plugins.
 */
class AemBasePlugin : Plugin<Project> {

    companion object {
        val PKG = "com.cognifide.gradle.aem"

        val ID = "com.cognifide.aem.base"
    }

    override fun apply(project: Project) {
        setupDependentPlugins(project)
        setupExtensions(project)
    }

    private fun setupDependentPlugins(project: Project) {
        project.plugins.apply(BasePlugin::class.java)
    }

    private fun setupExtensions(project: Project) {
        project.extensions.create(AemExtension.NAME, AemExtension::class.java, project)
    }

}