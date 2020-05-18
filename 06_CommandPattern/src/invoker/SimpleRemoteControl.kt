package invoker

import command.Command

class SimpleRemoteControl {
    var slot: Command? = null

    fun setCommand(command: Command) {
        slot = command
    }

    fun buttonWasPressed() {
        slot?.execute()
    }
}