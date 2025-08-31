package acuario

// 1) Clase base
open class SmartDevice(val name: String, val category: String) {
    var deviceStatus: String = "off"
    var deviceTurnOnCount: Int = 0
    open val deviceType: String = "unknown"

    fun turnOn() {
        deviceStatus = "on"
        deviceTurnOnCount++
        println("$name encendido")
    }

    fun turnOff() {
        deviceStatus = "off"
        println("$name apagado")
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

// 2) Subclase: TV
class SmartTvDevice(name: String, category: String) : SmartDevice(name, category) {
    override val deviceType = "Smart TV"
    private var volume: Int = 10
    private var channel: Int = 1

    fun increaseVolume() {
        if (deviceStatus == "on") {
            volume++
            println("Volumen subió a $volume")
        }
    }

    fun decreaseVolume() {
        if (deviceStatus == "on" && volume > 0) {
            volume--
            println("Volumen bajó a $volume")
        }
    }

    fun nextChannel() {
        if (deviceStatus == "on") {
            channel++
            println("Canal cambiado a $channel")
        }
    }

    fun previousChannel() {
        if (deviceStatus == "on" && channel > 1) {
            channel--
            println("Canal cambiado a $channel")
        }
    }
}

// 3) Subclase: Luz
class SmartLightDevice(name: String, category: String) : SmartDevice(name, category) {
    override val deviceType = "Smart Light"
    private var brightness: Int = 50

    fun increaseBrightness() {
        if (deviceStatus == "on" && brightness < 100) {
            brightness += 10
            println("Brillo subió a $brightness")
        }
    }

    fun decreaseBrightness() {
        if (deviceStatus == "on" && brightness > 0) {
            brightness -= 10
            println("Brillo bajó a $brightness")
        }
    }
}

// 4) Control central
class SmartHome(val tv: SmartTvDevice, val light: SmartLightDevice) {

    // Asegúrate de que las acciones se realicen cuando deviceStatus sea "on"
    fun turnOnAllDevices() {
        tv.turnOn()
        light.turnOn()
    }

    fun turnOffAllDevices() {
        tv.turnOff()
        light.turnOff()
    }

    // Métodos que pide el desafío
    fun decreaseTvVolume() = tv.decreaseVolume()
    fun changeTvChannelToPrevious() = tv.previousChannel()
    fun decreaseLightBrightness() = light.decreaseBrightness()

    fun printSmartTvInfo() = tv.printDeviceInfo()
    fun printSmartLightInfo() = light.printDeviceInfo()
}


fun main() {
    val tv = SmartTvDevice("LG OLED", "Entretenimiento")
    val light = SmartLightDevice("Philips Hue", "Iluminación")

    val smartHome = SmartHome(tv, light)

    // Encender
    smartHome.turnOnAllDevices()

    // Acciones que pide el desafío
    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToPrevious()
    smartHome.decreaseLightBrightness()

    // Info
    smartHome.printSmartTvInfo()
    smartHome.printSmartLightInfo()

    // Apagar
    smartHome.turnOffAllDevices()

    // Ver cuántas veces se encendió cada uno (opcional para mostrar contador)
    println("TV se encendió ${tv.deviceTurnOnCount} vez/veces")
    println("Luz se encendió ${light.deviceTurnOnCount} vez/veces")
}
