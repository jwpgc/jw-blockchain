package example


object Hello extends Greeting with App {
  println(greeting)
  
  val g = Block.genesis
  val b1 = NormalBlock(g, "Hello, Blockchain!!!", "xxxx")
  val b2 = NormalBlock(b1, "Next data!!", "yyyy")
  val b3 = NormalBlock(b2, "Next next data!!!", "zzz")
  
  printBlock(b3)
  
  println("Check: " + Block.validateBlock(b3))

  def printBlock(block: Block): Unit = {
    block match {
      case NormalBlock(b, data, free, hash) =>
        println(s"Block: $data, $free $hash")
        printBlock(b)
      case Genesis(hash) => println(s"Genesis $hash")
    }
  }
    
}

trait Greeting {
  lazy val greeting: String = "hello"
}

