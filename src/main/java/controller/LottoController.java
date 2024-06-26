package controller;

import lotto.*;
import lotto.generator.LottoGenerator;
import view.InputBonusNumberView;
import view.InputBuyLottoView;
import view.InputWinningLottoView;

import java.util.List;

import static view.outputBuyLottoCount.printBuyLotto;
import static view.outputLottoList.printLottoList;
import static view.outputStatistics.printStatistics;

public class LottoController {
    public void start() {
        Money money = getLottoMoney();
        printBuyLotto(money);

        Lottos lottos = getLottos(money);
        printLottoList(lottos);

        WinningLotto winningLotto = getWinningLotto();
        PrizeResult prizeResult = new PrizeResult();
        calcLottoResult(prizeResult, winningLotto, lottos);

        Rate rate = getRate(money, prizeResult);
        printStatistics(prizeResult, rate);
    }

    private Money getLottoMoney() {
        InputBuyLottoView inputBuyLottoView = new InputBuyLottoView();
        int money = inputBuyLottoView.getValue();
        return new Money(money);
    }

    private Lottos getLottos(Money money) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottoGroup(money.getTicket()));
    }

    private WinningLotto getWinningLotto() {
        InputWinningLottoView inputWinningLottoView = new InputWinningLottoView();
        InputBonusNumberView inputBonusNumberView = new InputBonusNumberView();

        List<Integer> winningNumbers = inputWinningLottoView.getValue();
        Integer bonusNumber = inputBonusNumberView.getValue();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void calcLottoResult(PrizeResult prizeResult, WinningLotto winningLotto, Lottos lottos) {
        prizeResult.calcPrizeResult(winningLotto, lottos);
    }

    private Rate getRate(Money money, PrizeResult prizeResult) {
        return new Rate(money, prizeResult);
    }
}
