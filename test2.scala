object sample {
  def main(args: Array[String]): Unit = {

    //整数配列および整数の設定
    val list: List[Int] = List(2,3,14,7,0,23,-7,56,24,107,42,24)
    val target: Int = 0
    println(list+"の中から"+target+"となる2組の組み合わせを探します")

    //負の整数用調整値設定
    var adjust_value: Int = 0
    if (list.min < 0) {
      adjust_value = list.min.abs
    }

    //重複削除、昇順ソートおよび値の絞込み
    val sort_list: List[Int] = list.distinct.sorted.takeWhile(_ <= target + adjust_value)
    val list_len:Int= sort_list.length
    var tmp_list1: List[Int] = sort_list
    var tmp_list2: List[Int] = sort_list

    //事前確認
    if(list_len < 2 || sort_list.max + sort_list.min > target || sort_list.max + sort_list(list_len - 2) < target) {
          println(target+"となる組み合わせはありません")
          System.exit(0)
    }

    //総当り確認
    while (tmp_list1.length != 1) {
      while (tmp_list2.length != 1) {
        if (tmp_list2.max + tmp_list2.min == target) {
          println("組み合わせが見つかりました")
          System.exit(0)
        }
        tmp_list2 = tmp_list2.tail
      }
      tmp_list1 = tmp_list1.init
      tmp_list2 = tmp_list1
    }
    println(target+"となる組み合わせはありません")
  }
}
