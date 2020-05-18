package command

import receiver.GarageDoor

class GarageDoorOpenCommand(val garageDoor: GarageDoor) : Command {
    override fun execute() {
        garageDoor.up()
    }
}