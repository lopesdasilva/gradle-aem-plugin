package com.cognifide.gradle.aem.instance

import com.cognifide.gradle.aem.AemTask
import com.cognifide.gradle.aem.deploy.SyncTask
import org.gradle.api.tasks.TaskAction

open class DownTask : SyncTask() {

    companion object {
        val NAME = "aemDown"
    }

    init {
        group = AemTask.GROUP
        description = "Turns off local AEM instance(s)."
    }

    @TaskAction
    fun down() {
        synchronizeLocalInstances { it.down() }
    }

}