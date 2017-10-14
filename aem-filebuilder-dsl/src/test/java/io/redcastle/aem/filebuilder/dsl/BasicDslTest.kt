package io.redcastle.aem.filebuilder.dsl

import io.redcastle.aem.filebuilder.model.dialog.Dialog
import io.redcastle.aem.filebuilder.model.dialog.StandardLayouts
import org.junit.jupiter.api.Test

class BasicDslTest {

    @Test
    fun testDsl() {
        val dialog = getDialog()
        val stream = getTestResource("io/redcastle/aem/filebuilder/dsl/BasicDslTest/testDsl.xml")

        val xmlDifference = getDifference(stream, dialog)

        assert(!xmlDifference.hasDifferences(), xmlDiffFormatter(xmlDifference))
    }

    private fun getDialog(): Dialog {
        return dialog("My Dialog", StandardLayouts.FIXED_COLUMNS) {
            textField("title", "./jcr:title") {
                fieldLabel = "Title"
                maxlength = 100
                emptyText = "Enter a title"
                required = true
            }
            textField("navTitle", "./navTitle") {
                fieldLabel = "Navigation Title"
                fieldDescription = "The title to be used in the the global nav when referring to this content"
                maxlength = 30
            }
        }
    }
}
