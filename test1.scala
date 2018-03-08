object sample1 {
    def main(args: Array[String]): Unit = {
      //二元連立一次方程式の定義(Xの係数,Yの係数,右辺の数)
      var siki1:List[Double] = List[Double](3,2,9)
      var siki2:List[Double] = List[Double](12,8,-7)

      //一時格納変数(倍数)
      var mult:Double = 0.0

      //計算処理
      //１行１列目を１に
      siki1 = siki1.map(i => i/siki1(0))
      //２行１列目を０に
      mult = siki2(0)
      (0 to 2).foreach(i => siki2 = siki2.updated(i,(siki2(i)-(siki1(i) * mult))))
      //２行２列目を１に
      siki2 = siki2.map(i => i/siki2(1))
      //１行２列目を０に
      mult = siki1(1)
      (0 to 2).foreach(i => siki1 = siki1.updated(i,(siki1(i)-(siki2(i) * mult))))

      //解の分類
      if (siki1(2).isInfinite || siki2(2).isInfinite) {
        println("解がありません")
      }
      else if(siki1(2).equals(Double.NaN) || siki2(2).equals(Double.NaN)){
        println("解が複数あります")
      }
      else{
        println("X=" + siki1(2) + " Y=" + siki2(2))
      }
    }
}
