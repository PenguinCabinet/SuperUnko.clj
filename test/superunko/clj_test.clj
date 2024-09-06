(ns superunko.clj-test
  (:require [clojure.test :refer :all]
            [superunko.clj :refer :all]))

(def Correct-SuperUnko-5th-Floor (apply str
                                        "　　　　　👑\n"
                                        "　　　　💩💩💩\n"
                                        "　　　💩👁💩👁💩\n"
                                        "　　💩💩💩👃💩💩💩\n"
                                        "　💩💩💩💩👄💩💩💩💩"))

((deftest generate-unko-body-test
   (testing "generate-unko-body-test"
     (is (= "👑" (generate-unko-body 0 unko-option)))
     (is (= "💩💩💩" (generate-unko-body 1 unko-option)))
     (is (= "💩👁💩👁💩" (generate-unko-body 2 unko-option)))
     (is (= "💩💩💩👃💩💩💩" (generate-unko-body 3 unko-option)))
     (is (= "💩💩💩💩👄💩💩💩💩" (generate-unko-body 4 unko-option)))
     (is (= "💩💩💩💩💩💩💩💩💩💩💩" (generate-unko-body 5 unko-option)))
     (is (= "💩💩💩💩💩💩💩💩💩💩💩💩💩" (generate-unko-body 6 unko-option))))))

((deftest generate-unko-test
   (testing "generate-unko-test-test"
     (is (= "　　　　　👑" (generate-unko 5 0 unko-option)))
     (is (= "　　　　💩💩💩" (generate-unko 5 1 unko-option)))
     (is (= "　　　💩👁💩👁💩" (generate-unko 5 2 unko-option)))
     (is (= "　　💩💩💩👃💩💩💩" (generate-unko 5 3 unko-option)))
     (is (= "　💩💩💩💩👄💩💩💩💩" (generate-unko 5 4 unko-option))))))

((deftest generate-super-unko-test
   (testing "generate-super-unko-test"
     (is (= Correct-SuperUnko-5th-Floor (generate-super-unko 5 unko-option))))))

((deftest generate-super-unko-parallel-test
   (testing "generate-super-unko-parallel-test"
     (is (= Correct-SuperUnko-5th-Floor (generate-super-unko-parallel 5 unko-option))))))

((deftest main-test
   (testing "generate-super-unko-parallel-test"
     (is (= Correct-SuperUnko-5th-Floor (app "5")))
     (is (= Correct-SuperUnko-5th-Floor (app "-p" "5")))
     (is (= "1以上の数字を入力してください" (app "0" "-p")))
     (is (= "数字を入力してください" (app))))))
