package com.cognifide.gradle.aem.deploy

import com.cognifide.gradle.aem.AemTask
import com.cognifide.gradle.aem.instance.InstanceSync
import org.gradle.api.tasks.TaskAction

open class PurgeTask : SyncTask() {

    companion object {
        val NAME = "aemPurge"
    }

    init {
        group = AemTask.GROUP
        description = "Uninstalls and then deletes CRX package on AEM instance(s)."
    }

    @TaskAction
    fun purge() {
        propertyParser.checkForce()

        synchronizeInstances({ sync ->
            try {
                val packagePath = sync.determineRemotePackagePath()

                uninstall(packagePath, sync)
                delete(packagePath, sync)
            } catch (e: DeployException) {
                logger.info(e.message)
                logger.debug("Nothing to purge.", e)
            }
        })
    }

    private fun uninstall(packagePath: String, sync: InstanceSync) {
        try {
            sync.uninstallPackage(packagePath)
        } catch(e: DeployException) {
            logger.info("${e.message} Is it installed already?")
            logger.debug("Cannot uninstall package.", e)
        }
    }

    private fun delete(packagePath: String, sync: InstanceSync) {
        try {
            sync.deletePackage(packagePath)
        } catch (e: DeployException) {
            logger.info(e.message)
            logger.debug("Cannot delete package.", e)
        }
    }

}
