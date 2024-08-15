func lemonadeChange(bills []int) bool {
    var fiveDollarBills, tenDollarBills int

    for _, bill := range bills {
        switch bill {
            case 5:
                fiveDollarBills++

            case 10:
                if !canPayBack(bill, fiveDollarBills, tenDollarBills) {
                    return false
                }

                fiveDollarBills--
                tenDollarBills++                
            
            case 20:
                if !canPayBack(bill, fiveDollarBills, tenDollarBills) {
                    return false
                }

                if tenDollarBills > 0 {
                    tenDollarBills--
                    fiveDollarBills--
                } else {
                    fiveDollarBills -= 3
                }
        }
    }

    return true
}

func canPayBack(bill, fiveDollarBills, tenDollarBills int) bool {
    required := bill - 5

    switch required {
        case 5:
            return fiveDollarBills > 0
        case 15:
            return fiveDollarBills >= 3 || (tenDollarBills > 0 && fiveDollarBills > 0)
    }

    return false
}