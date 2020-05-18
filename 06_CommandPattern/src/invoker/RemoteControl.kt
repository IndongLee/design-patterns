package invoker

import command.Command
import command.NoCommand

class RemoteControl {
    private val noCommand = NoCommand()
    private val onCommands = Array<Command>(7) { noCommand }
    private val offCommands = Array<Command>(7) { noCommand }
    private var undoCommand: Command = NoCommand()

    fun setCommand(slot: Int, onCommand: Command, offCommand: Command) {
        onCommands[slot] = onCommand
        offCommands[slot] = offCommand
    }

    fun onButtonWasPushed(slot: Int) {
        onCommands[slot].execute()
        undoCommand = onCommands[slot]
    }

    fun offButtonWasPushed(slot: Int) {
        offCommands[slot].execute()
        undoCommand = offCommands[slot]
    }

    fun undoButtonWasPushed() {
        undoCommand.undo()
    }
}