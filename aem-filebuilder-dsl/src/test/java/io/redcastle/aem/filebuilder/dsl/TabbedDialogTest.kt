package io.redcastle.aem.filebuilder.dsl

import io.redcastle.aem.filebuilder.convertNodeTreeToDocument
import io.redcastle.aem.filebuilder.stringContents
import org.junit.jupiter.api.Test
import org.xmlunit.builder.DiffBuilder
import org.xmlunit.builder.Input
import org.xmlunit.diff.DefaultComparisonFormatter
import org.xmlunit.diff.DefaultNodeMatcher
import org.xmlunit.diff.ElementSelectors

class TabbedDialogTest {
    @Test
    fun testDsl() {
        val dialog = dialog("My Dialog") {
            section("section1") {
                title = "My Section"
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

        println(convertNodeTreeToDocument(dialog).stringContents)

        val stream = Thread.currentThread().contextClassLoader.getResourceAsStream("io/redcastle/aem/filebuilder/dsl/TabbedDialogTest/testDsl.xml")

        val xmlDifference = DiffBuilder.compare(Input.fromStream(stream))
                .withNodeMatcher(DefaultNodeMatcher(ElementSelectors.byName))
                .checkForSimilar()
                .withNodeTest(dialog).build()

        assert(!xmlDifference.hasDifferences()) {
            xmlDifference.differences.joinToString(separator = "\n") { it.toString(DefaultComparisonFormatter()) }
        }
    }
}
