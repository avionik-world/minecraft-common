@file:Suppress("UNCHECKED_CAST")

package world.avionik.minecraft.common.option

/**
 * @author Niklas Nieberler
 */

interface IOptionProvider {

    fun <T : Any> getOption(key: String, defaultValue: T): T {
        return (getOptions().firstOrNull { it.key == key }?.value ?: defaultValue) as T
    }

    fun <T : Any> getOption(pair: Pair<String, T>): T {
        return (getOptions().firstOrNull { it.key == pair.first }?.value ?: pair.second) as T
    }

    fun hasOption(pair: Pair<String, Any>): Boolean {
        return getOptions().firstOrNull { it.key == pair.first } != null
    }

    fun getOptions(): List<Option>

}