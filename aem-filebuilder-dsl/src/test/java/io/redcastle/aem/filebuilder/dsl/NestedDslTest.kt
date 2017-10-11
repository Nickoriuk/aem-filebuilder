package io.redcastle.aem.filebuilder.dsl

import io.redcastle.aem.filebuilder.model.dialog.Dialog
import io.redcastle.aem.filebuilder.model.dialog.StandardLayouts

class NestedDslTest {
    fun getDialog(): Dialog {
        return dialog("Nested DSL Dialog", StandardLayouts.FIXED_COLUMNS) {
            fieldset("first") {
                title = "Fieldset 1"
                textField("text", "./text") {
                    fieldLabel = "Text 1"
                }
            }

            fieldset("second") {
                title = "Fieldset 2"
                textField("text", "./text2") {
                    fieldLabel = "Text 2"
                }
            }
        }
    }
}
