import common.RnaCodonTable
import common.split
import common.split2

/**
 * Created by egslava on 23/08/16.
 */
object Prot {

    val dataset = "AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA"

    val dataset2 = """AUGUCAGCUGCACUCGGGGGUCACUCCGUCGGGUUGGAGAUCUGCUCAUGUAGCCCGCCCCCUGUAACCUGGGGAAUGGCGAGGGCCUUGCAACGAGUGAUUGUCCUCAUAGACUGCAGUGCUUUCAAGCUUAGUCUGCUGCUUAUCCUAAUACCACCUUUUCUAUACUAUGAAUGUUCACGGCAUACAGCGAGAGUGGGAGACCUUUCGCGCGUCAUGGAAACGCGUGUGCGGUUACUGGCAUCCGAUCAUCCUCUUGGGUCUCCUCCCGGAGUUCAAACCGAUAUAAUCACAUGCCCGAUAAACCUCCGGGUCGGCAAGCUGUACCCACCGCAGUUCGUUCCGGAUCGGCAUCGCCCUUACCAAUCUCUCGUUUGGGAACCCGGAUACUGGGAAACGUGGUAUCUCAACAUUAACUCAUUUGUAUUUAACAGAAUGCCCCAUCGGACUAGUCUUAAGUACCUUGGCAGAUUGCGGGCAAUCAAUGCGCUCCUCCUGUCACGGUUCCAAGGUCAGACCUCCACAGCUCCAUGUUCGGAGACUGACCAGCUGCGUCGUGUUUACCGUAAAGAGCGAAUUGCAGAGCUCGUGCCGGUUUCCCAACCUCGUGAUAGCAAUGCACAACCUCUUGGGUACGAAUCGUUAGGGGAGACAGGAUGGCCAGGAGAACCGCCCCCAGCAGACCGCUCGCGGCGUCAGGACGCGUGUCUCUACCUAUGCCAAAGUGACGAUUACGGUAAAAUCGAAAUUAAUGUAACCUUCUCCAAGGACAUGAUCUCAAUCUUUUAUGUGCGUGUUCGAAGAGUUUCGGGCUGUCCGGAAGUUAUAGAGCCUGUUUGGAACCUCGUUGGCGUCACAAGAUGUGCUCCUUACCAGUACGAUAAAUGCAGGAGCAUCAAGAGUUCCACAGCUCCCGUGCCCAGUCGGUUUGAGGUAUUAGGCUCGGGACUUUGCGAUGUAGCUUGCCAAAGCCAGUAUAUGGAUGGUCUUAGUCAAAGGGCAACUGAGAUAUCCUAUAGGAGCGAGAAAGCCGGCCUGCAAGAAUGCGUAUCAGCGCGUAUAGUUGACUUUACGCCCCGGAUAGACGGUACAUAUACUACCCGUAUGUGGGUUACUGAUAAUAACAAGGUUGAUAAGGUGUCAGGCUGCGACGCUGGUAGGCUGACACCCCACGUGUUAUUCAGCCCAUCACCUGUAGAGUUUACCAGGUUCACGUUAGGACAGCGGCUACAAGGAACGACAAAGUACACUUGCAAACCAACAGUGUACCACCCCAGCGGUCCUCGUCUAGUAAGAGACAGCACAGAUUUCUUCUUGAGGGUUCUGACGUGCAGCCAGUAUGAGGUGAAACAUCCCCUACUAUCCCGUUCCUUGUCAGAUAGACCAGUAGUCACUUCUAAGAGUAUGAAAGGAUGGUCUGGAGCCAUUGGUGACAGCAGCUAUUGCCACUUACCUACGUUUUGGUUCGGAGAAAGGCUGCGCACCUCGAGAGUCCCCUACUAUUACGCCAGGACACCCCAUGUCGUCUGCUUAAUUAUCUUUUGUGCUGAAAUAUGUCAGACCCGCAUAAUGCUAGAAGGUAGGCUCCGAUCCUCCCCAAGCUCUGGCACCCGCUCUAUAUAUGUACCAGGUGUCGUGACCUGUACAGUCGAUAAUCAUAUUUACACUUCAUGUGUUGACUUUAUUCCGGUAUCCUUGAUAUGUCUCGAGAACGAUGCAACACCGAAUGGGUUGUACGUCCUGCACGGAAGAAGCUUGGGAUUCGUAGCACCGGCAGCUAUCCAAAGCGUGCAUGUCUGUGCAAUCUCUCCAGAUUUGGCGGUUAGACGACUGGAGGGUUAUAUCAGGUAUGCACCAGCGCGUGGACUUAAGCGCCUCAGUUCUGCAAGGGUCCAGAUCUCUCCGUUAGAAGUUGUUCCCGACGAUGUGUACCCCUUUGUGAGGAGGUACGCGUAUAGGCUCUGUAGCCUCUGCUCUAGCCCUUAUAUGCUCUACGCAAACAACGGGGAUGCAUGUGCGUAUGAAGUCAAGAUAGGCAACUUGCAAAGCAGGGCCGUGAGAGCGGAAUCCCAGGCUACCUCGGUGCAUAAGAUUAAGGUGGUUAGAGCUCCCUUUCCGGAUCCUAUUCGUUGCUUACUGCCACUACCGCGUCCUCUUUCCAUAUGUUCGGCCUGCGCUGAUGUGCGUUCAGAGUUAGCAGACUAUUUCUUCACCGAAGCGAAUAUUAGCGGGAGAAUUGGCUCAAUGGCUUUUCUCGAUUUUUACUUAACGGCAGGGGCGACAACCGCAAUGAUUAUACUACAGUUCAACCGCUUUCUUGCCAGAAACAAAAAGAACCGACGCACCUGGACUUCGAGAUAUGACGCUGCUGGUACCUGGGCGUCACUAUAUAUUGCACCCUUUACGGAACUGAACGCUCGCGUUCAAUCUCGCUUCCCUCAUCCAUUCCUCGAUGGGCCCCUUGGGGUUAUUUUUGUUGACUUUCAUGGAUUUGGAAUUGACAUGUAUCCUUACCGAGUACCUCGCACCGCCUACCUCAAUAGGCCGGCCAAUGUGAGUUUGAUCCCUUCCAGUGUGACAAAUAUUACCAACAAAAAUCGCGACUACAUUUCGAUCAACCUCCCACCACCGGCGAGCAUUCAUCUUAUGGUCCGGCUACUACGGCAGCUUCCGACCCCACGGCGGAAUCGGCCGUCCUCUCCGACUGCGGUCAUUCUGACGUUUCUUUUACGGCAGAUUUCUCCUACCCCUGCCAAAUGUACAGGAGCGAGCCAUCGGAUGGUCCUAUCUACUGACGUGGUGUUCGAGUUCGAGACAGACUUGGAUGUGUGUUUGCCGAUUCUCCGUAUUAACGCGGGUGUGAAUGACCCUUUGCAAUUUGGGCACUGGAAUCAAUUAAGACGGCUGGACGGAGCACGCGCUAUCCUGGGCCCGUACACGGAUCGGAGUGACAAAGAUGGUCGUCCCAAAUGCUGGUACGCCUUCGCCGUGGUGAUACUAACAUUCCACGGCCAACCGGCCUAUUGGGAGACGCAUCUUCCCAGCCAGGGGUCAUACCCGUGCUUAGCUCAAAAUGAGUUCAACGUGGCGACGACAUGUGCACAAGAACAGGGAAGCAAUAGGGAGCACGUCACUGCCAGUAUUGGAGGGAGCGAAAGAUCGAUCAGAAACGAAUAUCUGCUUCAAAAUGUGUGGGCGCAUCGAUGGGGGUCAAAUGUUCCCCUCCGAGUCAUUUACGCAUUGGAUCCCGCAUCGAGCGGGAGUUUCCAGAGACCGUCAGUAUAUGGGCACGGCUCCAUGCAAUCGUCCAGGUAUGUGGGGUCCCUAACAUGUUAUAAGGUGCAGAAUCUUCAUCUACGGGAUAGAGGGAAGUUCAUAAGGUCGAGCCUGCUGUCAACGCGGGGGAUUACCUGCAUAUGUGGACUGUCUCUUACUGAAGAUGGUCUGCCAGAGAGAUCUUCUCAUGGUGAAUCGCCCGUAGACAACCGUAGCCGCUAUUUAAAUGUAGGUGAGACUGUAGUAAUCCGUGCCACAGGCACCGAGUAUAAACCCGUCCGCGGUCUCGGUACCAUGUGUAUUGCCGACCAGUCCCAAACGUCAGGGGAUUAUUACGAGCAGGUUUCCUCCCCAACCCUGAACGACACAAACUCGAACAUGCCCGCUGGGAUACACUUGGACAGUCCCUCGGACCCUCUUAAACCUAAAAGUGAAUCGGCCGGGCUGUUACGCGUCCCGAUUCAGGUGGCUAACACUCUGGAAUACGGUUCCUCACCUAGGGGACAUAUAAUAGGACGUCAAUUCAGUACCUGCCCCUUAUCUCAUAGCACUAGCAAACUAAGUUGUAUCAUUAUGGGGUGUAGUGCUCUAACUGCUCGCGGUAGGAGUAGGCACUCGCCCAGGGGCAGACAAUCUCACCCUUAUCCGUUAUGCCCGCUAAAUAACCCGAUCUGGGUGAAUGGCCUAACCAACCCGAUCAUAGUUGAGACAUCAUGUUUCGCUUACGACGUGUACCAACAAUCCACCGUCAACGGAGACAGUUCACUCCCUGUAUGCCUUGACUCACACACCUCACCAGCGCAUAUUAGGGCGGGAAUCUCGACGUUCUUACCUGGGUCGGACUUAGUUAUAGUUAGCACGAAUGUAUUGAAACUCCCAUCGGACAUUUUGAGCCGCCAAUUCCGGUUUGGUGUACGUUGCGUUAUUUUAGCUAGCUUUAUACUUCUCACGAUUACUAUUCAAUCGUCCCCCCCCAAUUCACUACGUGGAGAGAUUCCUCUGCUCCAGUUCGAUCACCACCGGGAAUGUGCAUCGUACGCAACAGUAAGCCCGAAUGCCGGGUCCGCAGGCUACCUAGUAUUUACCUUGCCAGACUGUACGAUAAGUCGCUUAUCCCCGGGGGCCUUAGGUUCCACACCGGGAAGCCUAAUGAUAUCUGUGUUCUUAGACACAACGUGCAAGCCCCUGUCACAGUGGUACAGUAUCCGUGAACGUCGGCAGCCUUCUCCAUCCGAACAUGAGUUCAACGCGGGAUAUCGGGAGGAUUAUUCUCGGACGGAUGAUAUUCCUUGGGCCGACAAGCCAUCUAACGCAAAGUGCUUACACCCAAAUGCUGUUGUCAGCUCAACUAAUAUCACAUCCCCGGAGGGGGGGCCAGAUUGGUGGACGCAGAGUCACUCCUGUCUUCAUAGGGUUCAGCCUGCCCAGGUAGAAUCCACGCACGUCGCCAUAUCCGAUCAGCAUAGCAGGGAAUCCUCGGCUCCCUCCACCGUAUGGCGGCCGAGCUCCAGAUUUGAGAUAAGCGUCCUUAGCAUUGUCAUUUAUAAGACCGCAUUAACCGGCGAAGUGCUGAUCGGUGUUUUCCAUCAAACUUUUCUGUUAGGUCGGACUGCCUGUUCGUUGCCCUGCACAAUAGAUUAUUGUAAGGGGCGAGCCCGCGUGACGCCCUCCAGACACGUAGUGACUAGCCAACAGAAGCCUAUGUGCCAUAAGCACGAGAUAGGCCCAAACUCCCAGUUAAUGCCCGUCGCACUCAGUAGUCCAAGAGCUUUCAUAGCAUUCAGGUUUCCAGCAGGCACCUAUCGGCCGACCCGUGCCACCUUUGACUGUCUCCUGACAAUCCGGAUCUCCUCCAGUUGUCAUAAUGGAAUGGAGUUUACUGGCUAUACCUCCGGUUACUCCGCGCUUUGCAUAUUUCCUCGACCGUCUGUUCAGCUUAGUAUGGGUACCCUCUUCCAUGUACUUUUUAACCGAAGUACGGAAAGGAACUCGUGUUCCCUCCUUCAAUGGGGAGGGAGAAAUAGAGCGAGAAUGAGACUUACCCGUCCCCGGCAGGCGCUUGGAUCUCCAAGCAGUGACAGAGCGAAAUUAAAAGGCAGACUACCGAUGCUCGAACCACAGUCAUCAGAGAAGCUUUCCCUGCUCAGACGGGGGAGUAAAUUCACCGUGUGCGUCAAUGGCUUCGGUCCGCCAUUUGGCUGUCGUCGCUAUCGUAGAACACACGUUAUCGGGUUAGAUGUUGGAAGGACAAAGCGGGAAGGAGGAGACUUCCCGCCGACCAAACCGCUCAGGGACGCUGUCCGCUCUCCCUGGCGCCUUACGAGCCCGGCUUGGCGCGGAGACGGGCAACUGUCUCAUCUAUCAAUCUGGAUAUCUACCGUGCGGACAACUUGGUCUACCUUUCGUGUGGAAACAACUGAAUGGAGGCUCCCGAACUUACUGGCAACUCGUCAGCCCGAGAGCCGCGUCGGCCAGACCGCCCGUGCGACCAUCUAUGCCAGGGUAUUAAACUCGAUCGUGACUGUCUCCCGGAUAUUCCGAAUGUUAAGCGGAUGGCAGGGCCACGCGCUUUGCAUAGUCGGGGAUCGACUCGGGAGCUCGAUGUCCAAAACAGGUUACGUUAGGUUCCACUCGAUUCAGUCAUUAGGCUGUGAUAGUCCGCAGCUAGUAGCCCAGAUCUGCGUGUUAGGUACACCUCAAACCGGCCGAAAAAAGAAAUUGCGCCAGAUAAAUCGAAGAGUCGAUCGACACUGGAUAUUUCCGACACCCUCGUUAACUUCCACCACAGCAGAACGAUUUGGGCAGUGGGUUGUGCGACCCUCAAAACUAAAAUCAAACCACUCUACAUGUCCACCCAGUGGUCUGUAUUUCACUGAAAUCGAUCCAAGCCUCUUUUCACAGACUCAGUUGACGGGAGAGAAUCUCGUAGCAAAUUCACGGGAAUGUGCACUUCGCAGAAACCACAGGGUUAAGAUGUCACACAGGACGAAGAGUCCGUACAGCGCUACUCUCUUGUGUCGGUUAUCCCAAAACGUCCGGGGCCAAAUGCAAGCAACCCGCGACGCUCUUUGGGGUUUAAGAGUUCAGAAUGAUCUCCCCCCUUACAGGAAGUGUAUCGGCAGUAAAUAUCUACCAAGAGACUCACGUCACUGCAUUGAGGUUGGGACCAACCAAGACAUCGUAUCAAAAGAUUCUGUAGCACAUUCUGAUUCCAAUGCUCUCUCUAUAACCGGACCAGAUUCGAUUCGACGACGGGUUGGUAUCCGCCUUGUUAGCGGGCAACGAAAUCAAAUUAUAAGCCUCCCUCUAGCUCAGAUUUGGUUGUACUCGCGUCGAUUCUCUCCGCAACCGAUUACGAUUGUAGAGGAAGUGAACAUGUGUAACUUCAGAAUGACCCGCGGAAUUAGGCUCAGUCUUUGCACUCUGUGGUAUGGUUACUCUGGAAGCGACAGCCGGGCAAGUACAUUUCAUAAGCGCCAAAUCCCCCCGAAGCGUAAGUUAAUAGACUUACGCCCCUCGGUUAAAAAGCUUAGUAUCCCGGGGUUUCAAGGCGGCCCGUUCCUCUUGGGUUCGGUGGCACACAUAAAAGUUUCUGCCGGGGCCGAUGGUGGGCGUGGAAAAGAGUACGUACACAUGCCACGGGGUGACCACACCUCAUGGAUGGAACCUUGUGUCUGGGACAGGACUGCUAGUCUUUAUGGACGCCCAAGGGCUCGGUCCGAUAUAGGCACGUUGGUAUUAGCGCGGAUUAGCUGUUACGGCAAUGCUCUAGUAUGUAGUGUCCAGUAUUCAGCGUCAUACUCGACAACUAAACAACUGCAAACCAAUCACUCCCUGCGCGACUCUACGAGAACCGGAACGGCGUAUCAGGAUCCACGCAAUAGACGGAAAUCGAAUUAUCAAGUCCCCAACACUCAGCGUAGGCGGCACUCAUAUCAGUUCGAGUGUGAAACAAUCGAAUACACACAAGUACGGUUGUUGGCCUCAACGAGUCCGCUGAAAUGCAUUAAGUAUAUACGAAUACAGCGGGCCCCGAUAAGAGCCCGGUUGGGACCGACCUCCGUUACCAUCGGUUUUGUUAUCCACGCAUCUAACAAAUACGGCAGUCGCUCUUUAGCAGCACCCUUGAAUUCGCACAUAGUAACGUCAACGGGUAAGGUUCAAUGGGUGGCAGCUUCACGCGAUAUUGAAAGACUAGUUGGCGUUAGGUGUACCCUCUUGGAAGUAGUAGUAGGGCGUUCGAUGCCAGUCUCCACAUCCCCGUCAUAUACGACAAGCCAGGCGCCUCGACCAUUGGCUCUAAAAUGGUUUCGUUCCUCCCUCCCGUUUGCAUCCCAUCGCUAUGUUUCAUUACAAAUUGGCCCCAAACUCACUGUAAGGCGUGCAUUGAUUUCAGCCCUCCUGGGCAGCGAGGGGUCAGGUUUCUAUCACCUAUAUACUGGGAUCUUGAGCUUCAGUUAUAGGGGUGAUCGUCACCCAGCAAAGCGGCGUCUGCUAUGCCAGAGCAAUAGUAGCAUAUGGUGCUUACGAUUUAGUUGGUUGCAGGGCCCGUUUACUCUUACCAGCAGCAAGCUGGAGCAGCGUAUAAGUAACUUUGUAUUACUGUGCAGUUACUCCCUGAAGAUUUAUUCAGCCAUAGGGCAAUGCCCUCCAUUUAGUAACGAGGCGUCCACCGUUCCUACUGCGACCGGAAGUCGUUGUGCGCAUGCGCUGCCCCGACCGUUAGGAUCCCACGCUAAGUCCCGGCCGCUCAGUAAUCACAAGUCAACAACAAGCAGUACUGCUGACGGCCGAAUUCAAUUUGGUUUGAUGCCACCCGCCGCCGGCGGCAGUUUUCCCAAUCCAUGCCCUUUACCGUCCUCGCCCAGCCAGCGUCAAUUAGUGUGCGUUCUCAAUAGUUGCCCGAGUUGGUUGGGUUAUGUGUAA"""

    @JvmStatic fun main(args: Array<String>){

        val result = RnaCodonTable.rna2prot(dataset2).dropLast(1)
        result.split2(150).forEach { println(it) }

//        assert( result == "MAMAPRTEINSTRING")
    }
}