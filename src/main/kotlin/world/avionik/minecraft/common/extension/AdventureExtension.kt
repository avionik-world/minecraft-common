package world.avionik.minecraft.common.extension

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer

/**
 * @author Niklas Nieberler
 */

fun text(message: String): Component {
    return MiniMessage.miniMessage().deserialize(message)
}

fun Component.serializeToJson(): String {
    return GsonComponentSerializer.gson().serialize(this)
}

fun String.deserializeToComponent(): Component {
    return GsonComponentSerializer.gson().deserialize(this)
}