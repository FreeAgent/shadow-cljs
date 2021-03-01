(ns shadow.cljs.ui.components.runtimes
  (:require
    [shadow.experiments.grove :as sg :refer (<< defc)]
    [shadow.cljs.model :as m]
    [shadow.cljs.ui.components.inspect :as inspect]
    [goog.date.relative :as rel]))

(defn age-display [since]
  (rel/format since))

(defn build-lang-icon
  [lang]
  (case lang
    :cljs
    (<< [:svg.inline-block.h-5.w-5 {:viewBox "0 0 24 24" :version "1.1" :xmlns "http://www.w3.org/2000/svg" :xmlns:xlink "http://www.w3.org/1999/xlink" :aria-hidden "true"}
         [:path {:d "M6.63046154,15.1043077 C5.9929836,15.1483386 5.36862309,14.9084598 4.92461538,14.4489231 C4.50283246,13.917951 4.29387229,13.2489494 4.33846154,12.5723077 C4.29196889,11.8790757 4.50926186,11.193894 4.94676923,10.6541538 C5.4084281,10.1833102 6.05285072,9.93781591 6.71076923,9.98215385 C7.19469229,9.97325572 7.67455194,10.0719391 8.11569231,10.2710769 L7.79630769,11.1147692 C7.448651,10.9641687 7.07706295,10.8763502 6.69876923,10.8553846 C5.84307692,10.8553846 5.41846154,11.4221538 5.41846154,12.5547692 C5.38778316,12.9950516 5.49942696,13.4335367 5.73692308,13.8055385 C5.9621467,14.090779 6.31296763,14.2473893 6.67569231,14.2246154 C7.14060632,14.2238305 7.59757743,14.1040265 8.00307692,13.8766154 L8.00307692,14.7913846 C7.81631178,14.9014681 7.61312429,14.9809356 7.40123077,15.0267692 C7.14774616,15.0835829 6.88833455,15.109617 6.62861538,15.1043077 L6.63046154,15.1043077 Z" :fill "#96CA4B"}]
         [:polygon {:fill "#96CA4B" :points "10.9024615 15.0156923 9.852 15.0156923 9.852 8.064 10.9024615 8.064"}]
         [:path {:d "M12.5843077,17.2107692 C12.3182211,17.2189519 12.0527356,17.1808469 11.7996923,17.0981538 L11.7996923,16.2673846 C12.0017614,16.3212936 12.2099414,16.3489061 12.4190769,16.3495385 C12.8676923,16.3495385 13.092,16.096 13.092,15.5889231 L13.092,10.0707692 L14.1424615,10.0707692 L14.1424615,15.6581538 C14.1725836,16.0824031 14.0274514,16.5004505 13.7409231,16.8147692 C13.424122,17.0965893 13.0073593,17.2392798 12.5843077,17.2107692 Z" :fill "#5F7FBF"}]
         [:path {:d "M13.0264615,8.76923077 C13.0166362,8.61049004 13.0723584,8.45466813 13.1806154,8.33815385 C13.3010207,8.22905882 13.4606771,8.17372901 13.6227692,8.18492308 C13.7822017,8.16852709 13.9405414,8.22479781 14.0538718,8.33812819 C14.1672022,8.45145856 14.2234729,8.60979828 14.2070769,8.76923077 C14.2136174,8.9253805 14.1585934,9.07785677 14.0538462,9.19384615 C13.9365659,9.300747 13.7812096,9.35597002 13.6227692,9.34707692 C13.4609759,9.35608221 13.3021404,9.30103691 13.1806154,9.19384615 C13.0726087,9.07978572 13.0167835,8.92601587 13.0264615,8.76923077 L13.0264615,8.76923077 Z" :fill "#5F7FBF"}]
         [:path {:d "M19.6421538,13.6107692 C19.6631453,14.0445637 19.4660754,14.4601769 19.1169231,14.7184615 C18.6664357,15.0028582 18.1374548,15.1372846 17.6058462,15.1024615 C17.0605509,15.1251052 16.5173441,15.0221486 16.0181538,14.8015385 L16.0181538,13.8923077 C16.5239162,14.1412695 17.0774219,14.2782291 17.6409231,14.2938462 C18.2870769,14.2938462 18.6092308,14.0990769 18.6092308,13.7095385 C18.612651,13.5958557 18.5749611,13.4847523 18.5030769,13.3966154 C18.4009828,13.2901111 18.2810145,13.2023219 18.1486154,13.1372308 C17.9271708,13.022638 17.6987171,12.9221307 17.4646154,12.8363077 C17.0369633,12.6996184 16.6428788,12.4744272 16.308,12.1753846 C16.1014736,11.9394131 15.9937141,11.6329928 16.0070769,11.3196923 C15.9952071,10.9247831 16.1909843,10.5524912 16.5230769,10.3384615 C16.9410548,10.0839951 17.426524,9.96262783 17.9150769,9.99046154 C18.4831658,9.98821821 19.0449897,10.1091489 19.5618462,10.3449231 L19.2193846,11.1350769 C18.7958819,10.9412272 18.339577,10.8291084 17.8744615,10.8046154 C17.3206154,10.8046154 17.0436923,10.9643077 17.0436923,11.2772308 C17.0465668,11.4370588 17.1285191,11.585057 17.2624615,11.6723077 C17.560307,11.8534225 17.8769303,12.0016753 18.2067692,12.1144615 C18.5181141,12.226218 18.8167114,12.3707205 19.0975385,12.5455385 C19.2676472,12.6640537 19.4089702,12.8192566 19.5110769,12.9996923 C19.6057157,13.1901712 19.6523015,13.4009165 19.6467692,13.6135385 L19.6421538,13.6107692 Z" :fill "#5F7FBF"}]
         [:path {:d "M11.0713846,1.68461538 L11.2329231,1.66984615 L11.2329231,0.130153846 L11.0418462,0.145846154 C4.85432242,0.651987355 0.0905509492,5.821348 0.0905509492,12.0295385 C0.0905509492,18.2377289 4.85432242,23.4070896 11.0418462,23.9132308 L11.2329231,23.9289231 L11.2329231,22.3827692 L11.0713846,22.3689231 C5.71769568,21.888611 1.61554993,17.4019608 1.61554993,12.0267692 C1.61554993,6.65157762 5.71769568,2.16492743 11.0713846,1.68461538 Z" :fill "#96CA4B"}]
         [:path {:d "M20.7369231,3.92676923 C18.7114918,1.73284786 15.9344383,0.381724167 12.9581538,0.142153846 L12.7670769,0.126461538 L12.7670769,1.66984615 L12.9286154,1.68461538 C18.2837852,2.16499585 22.3870953,6.65286578 22.3870953,12.0295385 C22.3870953,17.4062111 18.2837852,21.8940811 12.9286154,22.3744615 L12.7670769,22.3892308 L12.7670769,23.9289231 L12.9581538,23.9132308 C17.5096176,23.5466412 21.4515038,20.6117253 23.107664,16.3564529 C24.7638242,12.1011805 23.8430713,7.27371609 20.7369231,3.92676923 Z" :fill "#5F7FBF"}]])

    :clj
    (<< [:svg.inline-block.h-5.w-5 {:viewBox "0 0 24 24" :version "1.1" :xmlns "http://www.w3.org/2000/svg" :xmlns:xlink "http://www.w3.org/1999/xlink" :aria-hidden "true"}
         [:path {:d "M11.6950154,12.0284308 L11.3136,12.8732308 C10.8391385,13.944 10.3137231,15.2562462 10.1217231,16.0940308 C10.0526769,16.3923692 10.0102154,16.7586462 10.0109538,17.1721846 L10.0331077,17.6780308 C10.7223654,17.9310209 11.450764,18.0607528 12.1849846,18.0612923 C12.8545205,18.0602065 13.5195603,17.9518804 14.1548308,17.7404308 C14.006338,17.6067685 13.8689049,17.4613092 13.7438769,17.3054769 C12.9042462,16.2347077 12.4356923,14.6654769 11.6946462,12.0273231 M8.59569231,6.70892308 C6.93203289,7.87742725 5.94099595,9.78236691 5.93907692,11.8153846 C5.94276923,13.896 6.96073846,15.7358769 8.52369231,16.8738462 C8.90695385,15.2765538 9.86843077,13.8140308 11.3095385,10.8827077 C11.2238769,10.6475077 11.1264,10.3901538 11.0171077,10.1198769 C10.6183385,9.11815385 10.0416,7.95507692 9.52726154,7.42449231 C9.2688,7.14941538 8.94683077,6.90756923 8.59532308,6.70818462" :fill "#91DC47"}]
         [:path {:d "M17.6270769,18.9803077 C16.8,18.8769231 16.1132308,18.7513846 15.5195077,18.5372308 C14.5152,19.0356923 13.3835077,19.3177846 12.1853538,19.3177846 C8.04,19.3177846 4.67963077,15.9577846 4.67889231,11.8113231 C4.67692005,9.64922453 5.61005524,7.59191116 7.23803077,6.16910769 C6.81149523,6.0640945 6.37391765,6.01054393 5.93464615,6.0096 C3.72923077,6.03396923 1.40787692,7.2528 0.443076923,10.5444923 C0.349292308,11.0237538 0.371076923,11.3859692 0.371076923,11.8153846 C0.371076923,18.3408 5.66104615,23.6307692 12.1857231,23.6307692 C16.1815385,23.6307692 19.7117538,21.6454154 21.8492308,18.6084923 C20.6935385,18.8964923 19.5810462,19.0345846 18.6288,19.0375385 C18.2717538,19.0375385 17.9368615,19.0183385 17.6267077,18.9806769" :fill "#63B132"}]
         [:path {:d "M15.4068923,16.6910769 C15.48,16.7272615 15.6450462,16.7863385 15.8758154,16.8516923 C17.4819492,15.6761897 18.4318527,13.8057287 18.4334769,11.8153846 L18.4327385,11.8153846 C18.4266415,8.36757796 15.6331605,5.57409693 12.1853538,5.568 C11.518757,5.5692689 10.8566381,5.67696294 10.224,5.88701538 C11.4923077,7.33292308 12.1026462,9.39913846 12.6926769,11.6595692 C12.6948923,11.664 12.8824615,12.2898462 13.2044308,13.1202462 C13.5241846,13.9495385 13.9798154,14.976 14.4771692,15.7240615 C14.8035692,16.2254769 15.1624615,16.5854769 15.4068923,16.6914462" :fill "#90B4FE"}]
         [:path {:d "M12.1857231,0 C8.22830769,0 4.72726154,1.94806154 2.58350769,4.93513846 C3.69932308,4.23618462 4.83876923,3.98436923 5.83273846,3.9936 C7.20627692,3.99729231 8.28590769,4.42338462 8.80393846,4.71470769 C8.92947692,4.78670769 9.04763077,4.86461538 9.16430769,4.94436923 C10.1159204,4.52482656 11.144624,4.30852213 12.1846154,4.30929231 C16.3303385,4.30966154 19.6910769,7.66929231 19.6918154,11.8157538 L19.6910769,11.8157538 C19.6910769,13.9056 18.8363077,15.7960615 17.4579692,17.1566769 C17.7961846,17.1947077 18.1569231,17.2183385 18.5287385,17.2164923 C19.8372923,17.2172308 21.2514462,16.9284923 22.3118769,16.0364308 C23.0034462,15.4541538 23.5820308,14.6012308 23.8995692,13.3225846 C23.9643163,12.8230226 23.997367,12.3198621 23.9985231,11.8161231 C24,5.29033846 18.7111385,0 12.1857231,0" :fill "#5881D8"}]])

    (<< [:span.inline-flex.items-center.px-2.5.py-0.5.rounded-full.text-xs.font-medium.bg-gray-100.text-gray-800.uppercase.tracking-wider
         "-"])))

(defc ui-runtime-table-row [ident]
  (bind {:keys [runtime-id runtime-info supported-ops] :as data}
    (sg/query-ident ident
      [:runtime-id
       :runtime-info
       :supported-ops]))

  (render
    (let [{:keys [lang build-id host type since user-agent desc]} runtime-info]

      (<< [:tr.bg-white
           [:td.max-w-0.w-full.px-6.py-4.whitespace-nowrap.text-sm.text-gray-900
            [:div.flex
             [:a.inline-flex.space-x-2.pl-1.group.truncate.text-sm {:href (if build-id
                                                                            (str "/build/" (name build-id))
                                                                            "#")}
              [:div
               (build-lang-icon lang)]
              [:div.inline-flex.space-x-2.pl-1
               [:p.text-gray-700.truncate.font-medium.group-hover:text-gray-900 runtime-id]
               [:p.text-gray-500.truncate.group-hover:text-gray-900 (when build-id (name build-id))]]]]]
           [:td.px-6.py-4.text-right.whitespace-nowrap.text-sm.text-gray-500
            [:p.text-gray-700.font-medium (when host (name host))] (or desc user-agent "")]
           [:td.px-6.py-4.text-right.whitespace-nowrap.text-sm.text-gray-500 (age-display since)]
           #_[:td.px-6.py-4.text-right.whitespace-nowrap.text-sm.text-gray-500
              (when (contains? supported-ops :cljs-eval)
                (<< [:a
                     {:class inspect/css-button
                      :href  (str "/runtime/" runtime-id "/cljs-eval")}
                     "cljs eval"]))
              (when (contains? supported-ops :clj-eval)
                (<< [:a
                     {:class inspect/css-button
                      :href  (str "/runtime/" runtime-id "/repl")}
                     "clj eval"]))
              (when (contains? supported-ops :db/get-databases)
                (<< [:a
                     {:class inspect/css-button
                      :href  (str "/runtime/" runtime-id "/db-explorer")}
                     "db explorer"]))]]))))

(defc ui-runtime-list-item [ident]
  (bind {:keys [runtime-id runtime-info supported-ops] :as data}
    (sg/query-ident ident
      [:runtime-id
       :runtime-info
       :supported-ops]))

  (render
    (let [{:keys [lang build-id host type since user-agent desc]} runtime-info]
      (<< [:li
           [:a.block.px-4.py-4.bg-white.hover:bg-gray-50
            {:href (if build-id (str "/build/" (name build-id)) "#")}

            [:div.flex.space-x-4
             [:div.font-medium.text-lg.text-right {:style "width: 30px;"}  runtime-id
              [:div (build-lang-icon lang)]]
             [:div.flex-1.flex.flex-col.truncate
              [:div.text-lg.font-medium (if build-id (name build-id) " -")]
              [:div.text-sm.text-gray-500.truncate
               [:div (when host (str (name host) " - ")) (or desc user-agent "")]
               [:div (age-display since)
                ]]]]]]))))

(defn ui-runtime-list [runtimes]
  (<< [:ul.divide-y.divide-gray-200.overflow-hidden.shadow
       (sg/keyed-seq runtimes identity ui-runtime-list-item)]))

(defc ui-page []
  (bind {::m/keys [runtimes-sorted]}
    (sg/query-root
      [::m/runtimes-sorted]))

  (render
    (<< [:div.flex-1.overflow-y-auto
         (ui-runtime-list runtimes-sorted)])))