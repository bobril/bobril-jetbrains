package tools.listeners

import com.intellij.openapi.project.Project
import configuration.connection.data.CompilationFinishedMessage
import tools.ErrorListModel
import java.awt.event.MouseEvent
import javax.swing.JList

class ErrorListClickListener(
    private val project: Project,
    private val errorListModel: ErrorListModel,
    private val list: JList<CompilationFinishedMessage>): MouseListClickedListener<CompilationFinishedMessage>(list) {

    override fun onClick(e: MouseEvent) {
        val message = errorListModel.getErrors()[list.selectedIndex]

        println("Clicked:" + "-" + message.text)

        openFile(project, message.fileName, message.pos[0], message.pos[1])
    }
}