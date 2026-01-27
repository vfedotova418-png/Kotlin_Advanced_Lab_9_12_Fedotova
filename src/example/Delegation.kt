package example

interface Base {
    fun someFun()
}
class BaseImpl() : Base {
    override fun someFun() {}
}
class Derived(someBase: Base) : Base by someBase

interface Messenger{
    fun sendTextMessage()
    fun sendVideoMessage()
}
class InstantMessenger(val programName: String) : Messenger{
    override fun sendTextMessage() = println("Send text message")
    override fun sendVideoMessage() = println("Send video message")
}
class SmartPhone(val name: String, m: Messenger) : Messenger by  m{
    override fun sendTextMessage() = println("Send sms")
}

interface PhotoDevice{
    fun takePhoto()
}
class PhotoCamera: PhotoDevice{
    override fun takePhoto() = println("Take a photo")
}