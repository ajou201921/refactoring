package ac.kr.ajou.dirt2;

import java.util.HashSet;
import java.util.Set;

public class IpAddressMacAddress {

    // single ip, single mac, accountId, ip + mac
    public Set<String> buildCombinedIdentification(PcBangEvent pbe) {
        Set<String> combineIdentification = new HashSet<String>();
        // single IP
        buildForSingleIp(pbe, combineIdentification);
        // single mac
        buildForSingleMac(pbe, combineIdentification);
        // accountId
        buildForAccountId(pbe, combineIdentification);
        // ip + mac
        buildForIpAndMac(pbe, combineIdentification);
        return combineIdentification;
    }
    private void buildForAccountId(PcBangEvent pbe, Set<String> combineIdentification) {
        if (isValidAccountId(pbe.getAccountId())) {
            if (!pbe.getAccountId().equals("0")) {
                combineIdentification.add(pbe.getAccountId());
            } else {
                System.out.println("Account id can't be 0");
            }
        }
        System.out.println("Account is is null or empty");
    }

    private boolean isValidAccountId(String accountId) {
        return accountId != null && !accountId.isEmpty();
    }

    private void buildForIpAndMac(PcBangEvent pbe, Set<String> combineIdentification) {
        if (isValidMac(pbe.getMac())) {
            if (pbe.getIp() != null && !pbe.getIp().isEmpty()) {
                String[] macAddresses = pbe.getMac().split(",");
                if (macAddresses.length <= 100) {
                    for (int i = 0; i < macAddresses.length; i++) {
                        combineIdentification.add(pbe.getIp() + macAddresses[i]);
                    }
                }
            }
        }
    }

    private boolean isValidMac(String mac) {
        return mac != null && !mac.isEmpty();
    }

    private void buildForSingleIp(PcBangEvent pbe, Set<String> combineIdentification) {
        if (pbe.getIp() != null) {
            combineIdentification.add(pbe.getIp());
        }
    }

    private void buildForSingleMac(PcBangEvent pbe, Set<String> combineIdentification) {
        if (isValidMac(pbe.getMac())) {
            String[] macAddresses = pbe.getMac().split(",");
            if (macAddresses.length <= 100) {
                for (int i = 0; i < macAddresses.length; i++) {
                    combineIdentification.add(macAddresses[i]);
                }
            } else {
                System.out.println("Mac address too many");
            }
        }
        System.out.println("Mac address is wrong");
    }
}
