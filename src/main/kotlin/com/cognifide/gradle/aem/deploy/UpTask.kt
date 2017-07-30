package com.cognifide.gradle.aem.deploy

import com.cognifide.gradle.aem.AemTask
import com.cognifide.gradle.aem.instance.AemLocalHandler
import org.gradle.api.tasks.TaskAction

open class UpTask : SyncTask() {

    companion object {
        val NAME = "aemUp"
    }

    init {
        group = AemTask.GROUP
        description = "Turns on local AEM instance(s)."
    }

    @TaskAction
    fun up() {
        synchronize({ AemLocalHandler(project, it.instance).up() })
    }

}