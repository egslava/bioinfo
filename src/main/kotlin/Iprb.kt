import com.sun.org.apache.xpath.internal.operations.Bool
import common.RnaCodonTable
import common.genes.Allele
import common.genes.Genotype
import common.split
import common.split2
import javafx.scene.Parent

/**
 * Created by egslava on 23/08/16.
 */

object Iprb {

    @JvmStatic fun main(args: Array<String>){
        val result = 0.78333
        val dataset = "2 2 2"   // 2 dominant, 2 homozygous, 2 recessive

        val y = Allele("y", false)
        val Y = Allele("Y", true)
        val YY = Genotype(Y, Y)
        val yY = Genotype(y, Y)
        val yy = Genotype(y, y)

        val (nDominants, nHeteros, nRecessives) = dataset.split(" ").map { it.toInt() }
        val genotypes = Array<Genotype>(nDominants + nHeteros + nRecessives){ when (it){
            in 0..nDominants-1 -> YY
            in nDominants..nDominants + nHeteros-1 -> yY
            else -> yy
        }}

        genotypes.forEach { println(it) }


//        val result = RnaCodonTable.rna2prot(dataset2).dropLast(1)
//        result.split2(150).forEach { println(it) }

//        assert( result == "MAMAPRTEINSTRING")
    }
}