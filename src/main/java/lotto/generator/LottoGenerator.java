package lotto.generator;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
public class LottoGenerator {
    public List<Lotto> generateLottoGroup(int createLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < createLottoCount) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    public Lotto generateLotto() {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        return new Lotto(lottoNumbersGenerator.generateLottoNumbers());
    }
}
