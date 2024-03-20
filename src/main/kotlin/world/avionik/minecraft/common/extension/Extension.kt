package world.avionik.minecraft.common.extension

import java.util.concurrent.CompletableFuture

/**
 * @author Niklas Nieberler
 */

fun <T> async(function: () -> T?): CompletableFuture<T>? {
    return CompletableFuture.supplyAsync { function() }
}

inline fun <T> Iterable<T>.allIndexed(predicate: (Int, T) -> Boolean): Boolean {
    if (this is Collection && isEmpty()) return true
    for ((i, element) in this.withIndex()) {
        if (!predicate(i, element)) return false
    }
    return true
}