# AEM Filebuilder

### Introduction
This library helps build dialogs for AEM by providing a DSL to build a dialog model that can be transformed into XML 
during your project's compilation.


#### Why?

XML is great for configuration, but it's difficult for developers to quickly read and write. This project is intended 
to solve that by introducing a natural DSL which is easy to read and write. It also brings several other benefits:

* Refer to your AEM bundle's constants directly in the Dialog DSL - ensure your dialog and Java classes are always 
  dealing with the same property name
* Share snippets of dialog code between different components using a shared DSL module
* Provides a simple, extensible API so you can develop your own DSL functions and types.
* Interoperable - use side by side with standard XML files
* Less error prone - statically typed DSL helps enforce correct dialog definitions.

This project currently only supports AEM 6.3 and higher.

### Quick Example
Example of a simple _cq_dialog.xml file written in Kotlin:

**apps/project/components/example/_cq_dialog.xml.kts**
```kotlin
import io.redcastle.aem.filebuilder.dsl.*
import io.redcastle.aem.filebuilder.model.dialog.field.Checkbox

dialog("My Dialog") {
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

        checkbox("showInNav", "./showInNav") {
            text = "Show In Nav"
            value = "{Boolean}true"
            fieldDescription = "If checked, the title will be displayed in the navigation"
            toolTipPosition = Checkbox.TooltipPosition.RIGHT
        }
    }
}

```

The above code creates the following dialog:

![image of dialog](docs/readme-dialog-example.png)

More samples can be found [here](samples/ui.apps/src/main/content/jcr_root/apps/aem-filebuilder/components).

### Artifacts

This repository is not on Maven Central or Bintray yet - it will be added when the project is less experimental.

### Dependencies

This project depends on the `filegen-maven-plugin` to convert the files to the typical XML format for AEM.

### Project Status

Everything is currently experimental, still in development and subject to change as part of the 0.x.x releases. 
These versions should not be considered production ready, as the API and implementation may change at any time 
prior to the 1.0.0 release.
