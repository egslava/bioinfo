package common.genes

/**
 * Created by egslava on 31/08/16.
 */
data class Allele (val name: String, val isDominant: Boolean)
data class Genotype (val first: Allele, val second: Allele){
    val isDominant: Boolean get() = first.isDominant && second.isDominant
    val isRecessive: Boolean get() = !isDominant
}
