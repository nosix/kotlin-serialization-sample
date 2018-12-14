package sample

import kotlinx.serialization.Serializable

@Serializable
data class ComplexData(val children: List<ChildData>) {
    constructor(vararg children: ChildData) : this(children.toList())
}
