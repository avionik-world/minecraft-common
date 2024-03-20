package world.avionik.minecraft.common.option

/**
 * @author Niklas Nieberler
 */

@Suppress("UNCHECKED_CAST")
open class OptionProvider : IOptionProvider {

    private val options = arrayListOf<Option>()

    fun addOptions(vararg option: Option) {
        this.options.addAll(option)
    }

    fun removeOption(name: String) {
        this.options.removeIf { it.key == name }
    }

    override fun <T : Any> getOption(key: String, defaultValue: T): T {
        return (getOptions().firstOrNull { it.key == key }?.value ?: defaultValue) as T
    }

    override fun <T : Any> getOption(pair: Pair<String, T>): T {
        return (getOptions().firstOrNull { it.key == pair.first }?.value ?: pair.second) as T
    }

    override fun getOptions(): List<Option> = this.options

}