package io.redcastle.aem.filebuilder.dsl

import io.redcastle.aem.filebuilder.convertNodeTreeToDocument
import io.redcastle.aem.filebuilder.model.dialog.Dialog
import io.redcastle.aem.filebuilder.model.dialog.StandardLayouts
import io.redcastle.aem.filebuilder.model.dialog.field.Checkbox
import io.redcastle.aem.filebuilder.model.dialog.field.TextField
import io.redcastle.aem.filebuilder.stringContents
import org.junit.jupiter.api.DisplayName

import org.junit.jupiter.api.Test

import org.xmlunit.builder.DiffBuilder.compare
import org.xmlunit.builder.Input
import org.xmlunit.diff.DefaultComparisonFormatter
import org.xmlunit.diff.DefaultNodeMatcher
import org.xmlunit.diff.ElementSelectors

@DisplayName("AEM Dialog Standalone Test")
class AemStandaloneDialogToXmlConversionTest {

    @Test
    @DisplayName("dialog with two fields should match template")
    fun testDialogWithTextField(){
        val stream = loadTestFile("test-xml/dialogs/simple-dialog.xml")

        val dialog = Dialog("Properties", StandardLayouts.FIXED_COLUMNS)
        val textField = TextField("text", "./text").apply {
            fieldLabel = "Text"
        }

        val checkbox = Checkbox("checkbox", "./checkbox").apply {
            text = "Checkbox"
            value = "{Boolean}true"
        }

        dialog.addField(textField)
        dialog.addField(checkbox)

        println(convertNodeTreeToDocument(dialog).stringContents)

        val xmlDifference = compare(Input.fromStream(stream))
                .withNodeMatcher(DefaultNodeMatcher(ElementSelectors.byName))
                .checkForSimilar()
                .withNodeTest(dialog).build()

        assert(!xmlDifference.hasDifferences()) {
            xmlDifference.differences.joinToString(separator = "\n") { it.toString(DefaultComparisonFormatter()) }
        }
    }
}
