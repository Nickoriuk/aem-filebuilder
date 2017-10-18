package io.redcastle.aem.filebuilder.dsl

import io.redcastle.aem.filebuilder.model.dialog.Dialog
import io.redcastle.aem.filebuilder.model.dialog.StandardLayouts
import org.junit.jupiter.api.Test

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

                select("select", "./select") {
                    fieldLabel = "My Select"

                    option("first") {
                        text = "First Option"
                        value = "1"
                    }

                    option("second") {
                        text = "Second Option"
                        value = "2"
                    }
                }
            }
        }
    }

    @Test
    fun test(){
        val dialog = getDialog()
        val stream = getTestResource("io/redcastle/aem/filebuilder/dsl/NestedDslTest/testDsl.xml")

        val xmlDifference = getDifference(stream, dialog)

        assert(!xmlDifference.hasDifferences(), xmlDiffFormatter(xmlDifference))

    }
}
