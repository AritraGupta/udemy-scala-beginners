package lectures.part2oop

object Enums extends App{

  enum Permission {
    case READ, WRITE, EXECUTE, NONE

    //add fields/methods
    def openDocument: Unit =
      if (this == READ) println("opening document")
      else println("reading not allowed")
  }

  //constructor arguments
  enum PermissionWithBits(bits: Int){
    case READ extends PermissionWithBits(4) //100
    case WRITE extends PermissionWithBits(2) //010
    case EXECUTE extends PermissionWithBits(1) //001
    case NONE extends PermissionWithBits(0) //000
  }

  val read = Permission.READ
  read.openDocument

  val somePermission = PermissionWithBits.READ

  object PermissionWithBits {
    def fromBits(bits: Int): PermissionWithBits = PermissionWithBits.NONE
  }

  //Standard API of Enums
  val somePermissionOrdinal = somePermission.ordinal
  val allPermissions = PermissionWithBits.values //array of all possible values of the enum
  val readPermission: Permission = Permission.valueOf("READ")


  println(somePermissionOrdinal)
  //println(allPermissions)
  println(readPermission)


}
