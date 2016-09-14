package common

/**
 * Created by egslava on 31/08/16.
 */


data class Node<T> (val parent: Node<T>?, var children: Array<Node<T>>?, val content: T){
    val isRoot: Boolean get() = parent == null
    val isLeaf: Boolean get() = children == null

    val root: Node<T> get() = parent?.root ?: this
    val level: Int get() = if (isRoot) 0 else parent!!.level + 1

    val leafs: List<Node<T>> get() = children?.flatMap { it.leafs } ?: listOf(this)
}
