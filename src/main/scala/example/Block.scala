package example

import com.google.common.hash.Hashing
import java.nio.charset.StandardCharsets

sealed trait Block {
  val hash: String
}
final case class Genesis(hash: String) extends Block
final case class NormalBlock(prev: Block, data: String, free: String, hash: String) extends Block

object Block {
  def hash(originalString: String) = {
    Hashing.sha256()
      .hashString(originalString, StandardCharsets.UTF_8)
      .toString();
  }
  def genesis = Genesis(Block.hash("The genesis block"))
  
  def validateBlock(block: Block):Boolean = block match {
    case g:Genesis => g.hash == genesis.hash
    case NormalBlock(prev, data, free, hash) => Block.hash(prev.hash + data + free) == hash && validateBlock(prev)
  }
}

object NormalBlock {
  def apply(prev: Block, data: String, free: String) = {
    new NormalBlock(prev, data, free, Block.hash(prev.hash + data + free))
  }
}