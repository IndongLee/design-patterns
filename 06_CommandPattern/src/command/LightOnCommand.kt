package command

import receiver.Light

class LightOnCommand(val light: Light) : Command {
    override fun execute() {
        light.on()
    }

    override fun undo() {
        light.off()
    }
}