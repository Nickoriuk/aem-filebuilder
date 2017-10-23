package io.redcastle.aem.filebuilder.samples

import io.redcastle.aem.filebuilder.dsl.option
import io.redcastle.aem.filebuilder.dsl.select
import io.redcastle.aem.filebuilder.model.dialog.FormFieldContainer

/**
 * Project standard theme field. When this function is updated, all dialogs across the project will automatically get
 * this updated definition.
 */
fun FormFieldContainer.theme() = select("theme", "./theme") {
    fieldLabel = "Web Theme"

    option("dark") {
        text = "Dark"
        value = "dark"
    }

    option("light") {
        text = "Light"
        value = ""
    }
}
