/*
 * Restricted usage, access limited to BFS team inside organization "TIETOEVRY"
 * Use this code to get below details
 * - Norwegian Bank Details and credentials to use in PR PIN project
 * - Payment Renewal Test Environment Details
 * - Creating new Test Environment in READYAPI and setting up service end points
 */
import java.util.HashMap;
import java.util.Map;

class DetectTestEnvironment {
    public static String[] getBankDetailsOf(String orgid) {
//    def listMap = [:];
        String[] listMap = new String[5];
        String oldBankOrgId;
        String credentials;
        String agentBankBic;
        String bankName;
//        listMap.put("orgid","")
//        listMap.put("oldBankOrgId","")
//        listMap.put("credentials","")
//        listMap.put("agentBankBic","")
//        listMap.put("bankName","")

        if (!orgid.isEmpty()) {
            switch (orgid) {
                case "1802":
                case "1801":
                    orgid = "1802";
                    credentials = "031110130104004259CjG5fYQwiCKYYovMhb%2FrJmTJZQe%2BFzz%2FRASphHZEo9Vo%2Bzq0WRhPZ%2FP3hY9BTDejrSIpQnXuqKD%2FMjoNuGS8RMPTmTCgkOmjGPUUQDIt8vpbiJn4Fc6bD%2F0%2B%2FgX%2BkhndHfX94rnv%2BvYLqKvAWlCL3GmfsOE%2BimPYAkyRKA%2FtIa1gSbV8PL7TnEYVTVAJx4r68CQtGWcP1JJdSy2emkS35z5zlVuQx1%2FZuR5EQEMBt0%3DMJ9mr8MlUz4bcCd6zAOV6sEczhY54JHkm33YPoXqjRlyrgjeDwGsKf%2Fcq92g4AzymsGcvdgyw4xZMm8dKHdTXtabRriIOvYGVB4iPLTunaQnnRzAImVO%2FbA5Fyss6UFyxc8WoWZlYQEjBGmq16rPU6ASBtaf1OhC18rl%2BAEiruY%3D";
                    agentBankBic = "SHEDNO22XXX";
                    bankName = "Sparebank 1 Østlandet";
                    oldBankOrgId = "1801";
                    break;
                case "2544":
                case "2489":
                    orgid = "2544";
                    credentials = "031110130104004250tu4YEEzPmBtrqnqspzaepmTJZQe%2BFzz%2FRASphHZEo9Vo%2Bzq0WRhPZ%2FP3hY9BTDejrSIpQnXuqKD%2FMjoNuGS8TkX6gR1agFyi03KQsWFB8BXfj%2BAtAgQbSaQcGy0csN5dHfX94rnv%2BvYLqKvAWlCL3GmfsOE%2BimPYAkyRKA%2FtIa1gSbV8PL7TnEYVTVAJx4r68CQtGWcP1JJdSy2emkS3y6yjge28rRaLF%2FZDAw52VE%3DF%2BBuvl5Swo7QVycQAlssDjzA%2FqUYwG5I%2Bn9Yc77Cs5IifWIRMpjIt89tk4zeyJMN6oeBYS9lDE7io0LHd6JJOdmFGZWyNUfk5%2BNO8WAxUjXVP4S5ZgUBHouwzBpDTyarrLwle0lsgGHBvaIeSsJ5ysnvZLV4aJjU2BawhuaDYjs%3D";
                    agentBankBic = "VEFONO21XXX";
                    bankName = "SpareBank 1 BV";
                    oldBankOrgId = "2489";
                    break;
                case "3201":
                case "3229":
                    orgid = "3201";
                    credentials = "03111013010400425%2BTtmFtxR%2FMqdvgamK6k6d5mTJZQe%2BFzz%2FRASphHZEo9Vo%2Bzq0WRhPZ%2FP3hY9BTDejrSIpQnXuqKD%2FMjoNuGS8RMPTmTCgkOmjGPUUQDIt8sfdn%2FX0ESHB%2BC%2Fdu2%2FMjDAdHfX94rnv%2BvYLqKvAWlCL3GmfsOE%2BimPYAkyRKA%2FtIa1gSbV8PL7TnEYVTVAJx4r68CQtGWcP1JJdSy2emkS3yVm%2FZktkwGVxbzUt0cgEVo%3DYOylu9Q2hknEBdhKBQZ3y0EhkOuxmxzg00bLf1JlN43718zhpPBrie07bfHhiXcpnwAOucAuDAVGmJ3JPt3B%2Fy4eGDxVLddD%2FplarxetvAhn7R38koB30sqnT0sTXTOf7%2FhYaUoHRhGQtKHfJ%2FsYf82RKwGF2Q96e6ej0lZQ%2BlQ%3D";
                    agentBankBic = "SPRONO22XXX";
                    bankName = "Sparebank 1 SR-Bank";
                    oldBankOrgId = "3229";
                    break;
                case "3240":
                case "3249":
                    orgid = "3240";
                    credentials = "03111013010400425f1NrHPQZaxr54KU0fLjn7JmTJZQe%2BFzz%2FRASphHZEo9Vo%2Bzq0WRhPZ%2FP3hY9BTDejrSIpQnXuqKD%2FMjoNuGS8RMPTmTCgkOmjGPUUQDIt8v5TVrl9i9Ebz5HgsZTR9midHfX94rnv%2BvYLqKvAWlCL3GmfsOE%2BimPYAkyRKA%2FtIa1gSbV8PL7TnEYVTVAJx4r68CQtGWcP1JJdSy2emkS30WgrppswDaomRTH1dsyqkc%3DPH8qz%2F7z%2FaW8t%2B7QUJjmEFuYSy9u1EJm6%2Fm98IN2CQxqfaenI2SpMloheua0L6go5YGKz5IwQjs%2F42NK0N5Mwka10DNUjhhdD4qYodUsk8FMEgJyW54n2YfD1mN9Kngx1ybMzyRzEdwXux7OAa6aKpdblmcwALeV1%2F380WYNBiI%3D";
                    agentBankBic = "HAUGNO21XXX";
                    bankName = "Haugesund Sparebank";
                    oldBankOrgId = "3249";
                    break;
                case "3411":
                case "3400":
                    orgid = "3411";
                    credentials = "03111013010400425PXR71G2bmEWm1n7P5D5kjpmTJZQe%2BFzz%2FRASphHZEo9Vo%2Bzq0WRhPZ%2FP3hY9BTDejrSIpQnXuqKD%2FMjoNuGS8RMPTmTCgkOmjGPUUQDIt8uFXnVMu4D8yollgi6lmcPmdHfX94rnv%2BvYLqKvAWlCL3GmfsOE%2BimPYAkyRKA%2FtIa1gSbV8PL7TnEYVTVAJx4r68CQtGWcP1JJdSy2emkS33tKhg3hIT5%2BMB9%2Fz7JtkwE%3DHMPxPioE2MGnA009bnVmZ4FixALmwieXnhUIrNK9vNDWL4yldrK%2Bpz9D3y4D%2FDISsfJfzlhjs58ySaaQ6Rmg0Ylo93glQ0rXKEmy%2FsonTDzICahURTNiFU%2Fkv7QBaN7gUxy301GWLze19oyRyymJXHB1OWkGdwyFHtzVWlgRCzI%3D";
                    agentBankBic = "FANANOB1XXX";
                    bankName = "Fana Sparebank";
                    oldBankOrgId = "3400";
                    break;
                case "3625":
                case "3601":
                    orgid = "3625";
                    credentials = "03110013010400445gft3cRnCLPWWq8xlQ7RTFGToxV2ar6TuwU6Z3UeBuPGOtIilCde6ooP8yOg24ZLxjrSIpQnXuqKD/MjoNuGS8Rw4mB1dHsCbdEPzxdSUScEOatyHX5qqpMbWdg9sXd9OjrSIpQnXuqKD/MjoNuGS8Y60iKUJ17qig/zI6DbhkvGOtIilCde6ooP8yOg24ZLxjrSIpQnXuqKD/MjoNuGS8VQ+cJDNKa9VYZxw7KIYbHB8cLeYBVPv9zeRx72/R0ziZwLpDJ3GXhXq1GEwqQfSKYJ2tYpapZTAlGka5wOfU82PaZrpEiGpF2MtWFUNZT5mGde8AMKM7YjZLq7bNqLJkX2jWnq8NpJv3mKcnhxevntuGj+LNVvt9Yd3A4XTDgHK8R22vZAGljeNQwWelwnd9cTDrDHgPSubME8PWzJvEoc=";
                    agentBankBic = "SPAVNOBBXXX";
                    bankName = "Sparebanken Vest";
                    oldBankOrgId = "3601";
                    break;
                case "3890":
                case "3702":
                    orgid = "3890";
                    credentials = "03111013010400425PXR71G2bmEWm1n7P5D5kjpmTJZQe%2BFzz%2FRASphHZEo9Vo%2Bzq0WRhPZ%2FP3hY9BTDejrSIpQnXuqKD%2FMjoNuGS8RMPTmTCgkOmjGPUUQDIt8uFXnVMu4D8yollgi6lmcPmdHfX94rnv%2BvYLqKvAWlCL3GmfsOE%2BimPYAkyRKA%2FtIa1gSbV8PL7TnEYVTVAJx4r68CQtGWcP1JJdSy2emkS33tKhg3hIT5%2BMB9%2Fz7JtkwE%3DHMPxPioE2MGnA009bnVmZ4FixALmwieXnhUIrNK9vNDWL4yldrK%2Bpz9D3y4D%2FDISsfJfzlhjs58ySaaQ6Rmg0Ylo93glQ0rXKEmy%2FsonTDzICahURTNiFU%2Fkv7QBaN7gUxy301GWLze19oyRyymJXHB1OWkGdwyFHtzVWlgRCzI%3D";
                    agentBankBic = "FANANOB1XXX";
                    bankName = "Fana Sparebank";
                    oldBankOrgId = "3702";
                    break;
                case "4701":
                case "4702":
                    orgid = "4701";
                    credentials = "03111013010400425PXR71G2bmEWm1n7P5D5kjpmTJZQe%2BFzz%2FRASphHZEo9Vo%2Bzq0WRhPZ%2FP3hY9BTDejrSIpQnXuqKD%2FMjoNuGS8RMPTmTCgkOmjGPUUQDIt8uFXnVMu4D8yollgi6lmcPmdHfX94rnv%2BvYLqKvAWlCL3GmfsOE%2BimPYAkyRKA%2FtIa1gSbV8PL7TnEYVTVAJx4r68CQtGWcP1JJdSy2emkS33tKhg3hIT5%2BMB9%2Fz7JtkwE%3DHMPxPioE2MGnA009bnVmZ4FixALmwieXnhUIrNK9vNDWL4yldrK%2Bpz9D3y4D%2FDISsfJfzlhjs58ySaaQ6Rmg0Ylo93glQ0rXKEmy%2FsonTDzICahURTNiFU%2Fkv7QBaN7gUxy301GWLze19oyRyymJXHB1OWkGdwyFHtzVWlgRCzI%3D";
                    agentBankBic = "SNOWNO22XXX";
                    bankName = "Sparebank 1 Nord-Norge";
                    oldBankOrgId = "4702";
                    break;
                case "9001":
                case "9898":
                    orgid = "9001";
                    credentials = "03111013010400425eblN3HH6rvLDJvGWdXyMcJmTJZQe%2BFzz%2FRASphHZEo9Vo%2Bzq0WRhPZ%2FP3hY9BTDejrSIpQnXuqKD%2FMjoNuGS8RMPTmTCgkOmjGPUUQDIt8vrXrjxcPc4VoMCtTDQmUiYdHfX94rnv%2BvYLqKvAWlCL3GmfsOE%2BimPYAkyRKA%2FtIa1gSbV8PL7TnEYVTVAJx4r68CQtGWcP1JJdSy2emkS378HnJBf3QS1prLJ4z1O9g8%3DTFEUjfUUes7i5g0M1GyYPjDw66rjprIPQ%2Fab8h0TQJCQL8iPHO%2F%2FwKiwXKIY7W0ZfCst7qIFqtm63Ak%2Ff%2FNlWv0g8HWyfauLo%2FXPclMaLiE5VKhKWv0stqvLtH%2FFHI6%2BAkz%2FcI3yACJX7itX3WeBIHPGrTXBlm9qwe21PbKfTbs%3D";
                    agentBankBic = "LABANOKKXXX";
                    bankName = "Bank 1 Oslo AS";
                    oldBankOrgId = "9898";
                    break;
                case "9055":
                case "9057":
                    orgid = "9055";
                    credentials = "03111013010400425D%2F7H7Z5gg09DwvXpTjq9yZmTJZQe%2BFzz%2FRASphHZEo9Vo%2Bzq0WRhPZ%2FP3hY9BTDejrSIpQnXuqKD%2FMjoNuGS8SPw4jIv3rXSzgpq4N9jjv%2FiyOYGOgvTSRjrfX3AqOt%2FdHfX94rnv%2BvYLqKvAWlCL3GmfsOE%2BimPYAkyRKA%2FtIa1gSbV8PL7TnEYVTVAJx4r68CQtGWcP1JJdSy2emkS301roLRkJpcTJ5euYXWp28M%3DDT0PUyyJYPtJYATi9lKmcZlZ%2FQ4AfLGdMV4vQsJLHsWdw0nazr2OjOS6N%2B7pP1Q2e%2BwGoMDIhW2TQtY68ZAqc8hAK%2FCY0hxv9PPFSi0NaV3y%2FvTZGib7vNufOAZaaAUJa4286UAGn2RDUYHbhBIGRCpWgkXKN4jp0X%2FWvSeRkvA%3D";
                    agentBankBic = "HANDNOKKXXX";
                    bankName = "Handelsbanken";
                    oldBankOrgId = "9057";
                    break;
                case "35803100":
                    orgid = "35803100";
                    credentials = "03111013010400425GWfpot6k%2Fmks%2FEYCsehqE%2B6ypxDnhoQe1cPSToeH6a9Vo%2Bzq0WRhPZ%2FP3hY9BTDejrSIpQnXuqKD%2FMjoNuGS8RMPTmTCgkOmjGPUUQDIt8sl98Nba9Trkx34QzE3Ly%2BmdHfX94rnv%2BvYLqKvAWlCL3GmfsOE%2BimPYAkyRKA%2FtIa1gSbV8PL7TnEYVTVAJx4r68CQtGWcP1JJdSy2emkS34HmOXBCM1LvQxeD1DqTYeQ%3Dup6z7NbZXlvojNz0S2ximCbT2zXJUjXrDKqtkwb0CoA7SX%2BL7Ecls7IhwUH4DcYjClsKGiLdDbYLBGJ2oLAbswvr8PWxvigfnMuEwm9YJZ0eahd%2B4V6Qo1W%2FRcAT1Vrjqdz5yx1c7Zmna3px9f7QmVSpv0Ki%2FjxI%2FdczJpdrLlA%3D";
                    agentBankBic = "HANDNOKKXXX";
                    bankName = "Handelsbanken Finland";
                    oldBankOrgId = "35803100";
                    break;
                case "4201":
                case "4210":
                default:
                    orgid = "4201";
                    credentials = "03110012010400425kglPboRi3h16OVtVL1neI9CfuAtjCBO603eS0IgWm1WWIO7EfpSL4DE%2FlDFi69n1sSaabKNt2t%2BxJppso23a37EmmmyjbdrfutbV53%2FUXGOxjDkLmirISLEmmmyjbdrfsSaabKNt2t%2FXzlyjxYnxhcG46wcbIKp%2FsSaabKNt2t9wBUG0SyIoqFfig80Gq4uXVBtimDzTiu2xJppso23a37Emmmyjbdrf8wP73CNrvpw%3DH5LS2JD%2BVebr3PytlKAocCy8%2FCcrl7tRSepyb0jhKW8A8k07nuvorl7Xoscy%2BybGjXIr2Zj%2Fvprt%2BD1IueT5rqEcvxyyr%2FYELRuLkDS94SfjVw%2FszcGGYfeWnI2Z1NwXorQAZPvT5U6Edafp2sbvWiNKkrzCmFJ4YcuHbGSJCYk%3D";
                    agentBankBic = "SPTRNO22XXX";
                    bankName = "SpareBank 1 SMN";
                    oldBankOrgId = "4210";
            }
//            listMap.put["orgid",orgid];
//            listMap.put["oldBankOrgId",oldBankOrgId];
//            listMap.put["credentials",credentials];
//            listMap.put["agentBankBic",agentBankBic];
//            listMap.put["bankName",bankName];
            listMap[0] = orgid;
            listMap[1] = oldBankOrgId;
            listMap[2] = credentials;
            listMap[3] = bankName;
            listMap[4] = agentBankBic;
            return listMap;
        }
    }

    public static String[] getDetailsOf(String value) {
        String[] list = new String[15];
        value= value.toLowerCase();
        String env = "d4";
        String pbd = "s2";
        String core = "s3";
        String eos_ip;
        String ebs_ip;
        String pbd_ip;
        String core_ip;
        String ftsOnline = "10.246.89.245:13610";
        String ftsBatch = "10.246.89.46:5127";
        String schema = "pwhdata";
        String paswd = "pwh";
        String aixData = null;
        String exaData = null;
        String aixUrl;
        String exaUrl;
        String pwhAixUrl;
        String pwhExaUrl;
        String databaseConnection = null;
        String dbConnectionWithHost = null;
        String mq_send = "PAIN001.PRFUNC.CPS.PIN.ONLINE";
        String mq_recieve = "QT0PPI.PAIN001.PRFUNC.CPS.PIN.ONLINE";
        String mQHostName = "10.246.89.48";
        String mQPort = "1430";
        String mqQueueManager = "QT0PPI";
        String mQChannelAuth = "QT0PPI.SEPA.CL";

        if (value.contains("d2") || value.contains("10.246.89.106:22411")) {
            env = "d2";
            pbd = "d6";
            core = "s3";
            eos_ip = "10.246.89.106:22411";
            exaData = "(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=dlt-exa853-scan.unix.cosng.net)(PORT=1530)))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_g_d2)))";
            mq_send = "PAIN001.SPRINT.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.SPRINT.CPS.PIN.ONLINE";
        } else if (value.contains("d3") || value.contains("10.246.89.107:22521")) {
            env = "d3";
            pbd = "s2";
            core = "s3";
            eos_ip = "10.246.89.107:22521";
            exaData = "(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=dlt-exa853-scan.unix.cosng.net)(PORT=1530)))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_g_d3)))";
            mq_send = "PAIN001.D3.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.D3.CPS.PIN.ONLINE";
        } else if (value.contains("d4") || value.contains("10.246.89.107:23621")) {
            env = "d4";
            pbd = "s2";
            core = "s3";
            eos_ip = "10.246.89.107:23621";
            exaData = "(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=dlt-exa853-scan.unix.cosng.net)(PORT=1530)))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_g_d4)))";
            mq_send = "PAIN001.PRFUNC.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.PRFUNC.CPS.PIN.ONLINE";
        } else if (value.contains("d5") || value.contains("10.246.89.107:22561")) {
            env = "d5";
            pbd = "d6";
            core = "s3";
            eos_ip = "10.246.89.107:22561";
            aixData = "10.246.89.97:1530/pwh_g_d5";
            mq_send = "PAIN001.SPRINTREL.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.SPRINTREL.CPS.PIN.ONLINE";
        } else if (value.contains("d6") || value.contains("10.246.89.108:22641")) {
            env = "d6";
            pbd = "d6";
            core = "s3";
            eos_ip = "10.246.89.108:22641";
            exaData = "(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=dlt-exa853-scan.unix.cosng.net)(PORT=1530)))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_g_d6)))";
            mq_send = "PAIN001.D6.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.D6.CPS.PIN.ONLINE";
        } else if (value.contains("d7") || value.contains("10.246.89.106:20811")) {
            env = "d7";
            pbd = "s2";
            core = "s3";
            eos_ip = "10.246.89.106:20811";
            exaData = "(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=dlt-exa853-scan.unix.cosng.net)(PORT=1530)))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_g_d7)))";
            mq_send = "PIN.D7.CPS.PAIN001ONLINE";
            mq_recieve = "PIN.D7.CPS.PAIN001ONLINE.QL";
        } else if (value.contains("d8") || value.contains("10.246.89.108:29221")) {
            env = "d8";
            pbd = "s2";
            core = "s3";
            eos_ip = "10.246.89.108:29221";
            exaData = "(CONNECT_TIMEOUT=10)(RETRY_COUNT=3)(RETRY_DELAY=1)(TRANSPORT_CONNECT_TIMEOUT=1)(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=dlt-exa853-scan.unix.cosng.net)(PORT=1530)))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_g_d8)))";
            mq_send = "PAIN001.D8.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.D8.CPS.PIN.ONLINE";
        } else if (value.contains("d9") || value.contains("10.246.89.212:29181")) {
            env = "d9";
            pbd = "s2";
            core = "s3";
            eos_ip = "10.246.89.212:29181";
            exaData = "(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=10.246.89.97)(PORT=1530))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_g_d9)))";
            mq_send = "PAIN001.D9.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.D9.CPS.PIN.ONLINE";
        } else if (value.contains("d10") || value.contains("10.246.89.212:29191")) {
            env = "d10";
            pbd = "s2";
            core = "s3";
            eos_ip = "10.246.89.212:29191";
            exaData = "(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=10.246.89.97)(PORT=1530))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_g_d10)))";
            mq_send = "PAIN001.D10.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.D10.CPS.PIN.ONLINE";
        } else if (value.contains("d11") || value.contains("10.246.89.212:29201")) {
            env = "d11";
            pbd = "s2";
            core = "s3";
            eos_ip = "10.246.89.212:29201";
            exaData = "(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=10.246.89.97)(PORT=1530))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_g_d11)))";
            mq_send = "PAIN001.D11.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.D11.CPS.PIN.ONLINE";
        } else if (value.contains("d12") || value.contains("10.246.89.212:29211")) {
            env = "d12";
            pbd = "s2";
            core = "s3";
            eos_ip = "10.246.89.212:29211";
            exaData = "(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=10.246.89.97)(PORT=1530))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_g_d12)))";
            mq_send = "PAIN001.D12.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.D12.CPS.PIN.ONLINE";
        } else if (value.contains("d13") || value.contains("10.246.89.108:29231")) {
            env = "d13";
            pbd = "s5";
            core = "s3";
            eos_ip = "10.246.89.108:29231";
            exaData = "(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=10.246.89.97)(PORT=1530))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_g_d13)))";
            mq_send = "PAIN001.D13.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.D13.CPS.PIN.ONLINE";
        } else if (value.contains("d14") || value.contains("10.246.89.108:29241")) {
            env = "d14";
            pbd = "s5";
            core = "s3";
            eos_ip = "10.246.89.108:29241";
            exaData = "(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=10.246.89.97)(PORT=1530))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_g_d14)))";
            mq_send = "PAIN001.D14.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.D14.CPS.PIN.ONLINE";
        } else if (value.contains("d15") || value.contains("10.246.89.108:29251")) {
            env = "d15";
            pbd = "s5";
            core = "s3";
            eos_ip = "10.246.89.108:29251";
            exaData = "(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=10.246.89.97)(PORT=1530))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_g_d15)))";
            mq_send = "PAIN001.D15.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.D15.CPS.PIN.ONLINE";
        } else if (value.contains("d16") || value.contains("10.246.89.108:29101")) {
            env = "d16";
            pbd = "s5";
            core = "s3";
            eos_ip = "10.246.89.108:29101";
            exaData = "(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=10.246.89.97)(PORT=1530))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_g_d16)))";
            mq_send = "PAIN001.D16.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.D16.CPS.PIN.ONLINE";
        } else if (value.contains("d17") || value.contains("10.246.89.108:25781")) {
            env = "d17";
            pbd = "s2";
            core = "s2";
            eos_ip = "10.246.89.108:25781";
            aixData = "10.246.89.97:1530/pwh_g_d17";
            mq_send = "PAIN001.D17.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.D17.CPS.PIN.ONLINE";
        } else if (value.contains("s1") || value.contains("10.246.89.245:10810") || value.contains("10.246.89.109:20811")
                || value.contains("10.246.89.110:20811")) {
            env = "s1";
            pbd = "s2";
            core = "s3";
            eos_ip = "10.246.89.245:10810";
            aixData = "10.246.89.97:1530/pwh_g_st";
            mq_send = "PAIN001.PRSYS.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.PRSYS.CPS.PIN.ONLINE";
        } else if (value.contains("s4") || value.contains("10.246.89.245:15780")) {
            env = "s4";
            pbd = "s4";
            core = "s2";
            eos_ip = "10.246.89.245:15780";
            aixData = "10.246.89.97:1530/pwh_g_s4";
            mq_send = "PIN.S4.CPS.PAIN001ONLINE";
            mq_recieve = "QT0PPI.PIN.S4.CPS.PAIN001ONLINE";
        } else if (value.contains("n1") || value.contains("10.246.89.245:11190") || value.contains("10.246.89.150:21191")
                || value.contains("10.246.89.150:21192") || value.contains("10.246.89.151:21192") || value.contains("10.246.89.152:21192")) {
            env = "n1";
            pbd = "n1";
            core = "s3";
            eos_ip = "10.246.89.245:11190";
            exaData = "(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=dlt-exa853-scan.unix.cosng.net)(PORT=1530)))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_g_n1)))";
            mq_send = "PAIN001.PRNF.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.PRNF.CPS.PIN.ONLINE";
        } else if (value.endsWith("d1") || value.contains("139.114.216.23:21171")) {
            env = "d1";
            pbd = "s6";
            core = "a";
            eos_ip = "139.114.216.23:21171";
            aixData = "139.114.222.25:1530/pwh_r_devel";
            mq_send = "PAIN001.T4.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.T4.CPS.PIN.ONLINE";
        } else if (value.contains("s6") || value.contains("139.114.216.245:11730") || value.contains("139.114.216.12:21731")
                || value.contains("139.114.216.13:21731")) {
            env = "s6";
            pbd = "s6";
            core = "u";
            eos_ip = "139.114.216.245:11730";
            exaData = "(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=dlt-exa851-scan.unix.cosng.net)(PORT=1530)))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_r_s6)))";
            mq_send = "PIN.S6.CPS.PAIN001ONLINE";
            mq_recieve = "QT0PPI.PIN.S6.CPS.PAIN001ONLINE";
        } else if (value.contains("s8") || value.contains("139.114.216.245:12390") || value.contains("139.114.216.12:22391")
                || value.contains("139.114.216.13:22391")) {
            env = "s8";
            pbd = "s6";
            core = "u";
            eos_ip = "139.114.216.245:12390";
            aixData = "139.114.222.25:1530/pwh_r_s8";
            mq_send = "PAIN001.S8.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.S8.CPS.PIN.ONLINE";
        } else if (value.contains("a1") || value.contains("139.114.216.245:11460") || value.contains("139.114.216.59:21461")
                || value.contains("139.114.216.60:21461")) {
            env = "a1";
            pbd = "s6";
            core = "u";
            eos_ip = "139.114.216.245:11460";
            exaData = "(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=dlt-exa851-scan.unix.cosng.net)(PORT=1530)))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_r_a1)))";
            mq_send = "PAIN001.A1.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.A1.CPS.PIN.ONLINE";
        } else if (value.contains("a4") || value.contains("139.114.216.245:12470") || value.contains("139.114.216.108:22471")
                || value.contains("139.114.216.109:22471")) {
            env = "a4";
            pbd = "a4";
            core = "c";
            eos_ip = "139.114.216.245:11460";
            exaData = "(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=dlt-exa851-scan.unix.cosng.net)(PORT=1530)))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pwh_r_a4)))";
            mq_send = "PAIN001.A4.CPS.PIN.ONLINE";
            mq_recieve = "QT0PPI.PAIN001.A4.CPS.PIN.ONLINE";
        } else {
            value = null;
            eos_ip = null;
            System.out.println("*****Could Not identifyTest Environment*****: ");
        }

        if (value != null) {

//            Differentiate BATCH servers in PIN
            switch(env) {
                case "d4":
                case "d6":
                case "d9":
                case "d10":
                case "d11":
                case "d12":
                case "d13":
                case "d14":
                case "d15":
                case "d16":
                case "d17":
                    ebs_ip = "10.246.89.207";
                    break;
                case "d2":
                case "d3":
                case "d5":
                case "d7":
                case "d8":
                    ebs_ip = "10.246.89.79";
                    break;
                case "s1":
                case "s4":
                    ebs_ip = "10.246.89.82";
                    break;
                case "n1":
                    ebs_ip = "10.150.187.40";
                    break;
                case "d1":
                case "s6":
                case "s8":
                case "a1":
                case "a4":
                    ebs_ip = "139.114.216.65";
                    ftsOnline = "139.114.222.17:5114";
                    ftsBatch = "139.114.222.26:5120";
                    mQHostName = "139.114.216.8";
                    mQPort = "1415";
                    mqQueueManager = "QT0RNMQ";
                    mQChannelAuth = "QT0RNMQ.SEPA.CL";
                    break;
                default: throw new IllegalArgumentException("*****Could Not identifyTest Environment*****: "+env);
            }

//            Differentiate Test Environments using EXADATA and AIXDATA Database
            if (env.equals("d2") || env.equals("d3")  || env.equals("d4")  || env.equals("d6") || env.equals("d7") || env.equals("d8") || env.equals("d13")  || env.equals("d14")  || env.equals("d15") || env.equals("d16")  || env.equals("n1")  || env.equals("s6")  || env.equals("a1") || env.equals("a4")) {

                exaUrl = "jdbc:oracle:thin:@" + exaData;
                pwhExaUrl = "jdbc:oracle:thin:"+schema+"/"+paswd+"@//" + exaData;

                databaseConnection = exaUrl;
                dbConnectionWithHost = pwhExaUrl;
            }
            else if (env.equals("d5") || env.equals("d9") || env.equals("d10") || env.equals("d11") || env.equals("d12") || env.equals("d17") || env.equals("d1") || env.equals("s8") || env.equals("s1") ) {

                aixUrl = "jdbc:oracle:thin:@" + aixData;
                pwhAixUrl = "jdbc:oracle:thin:"+schema+"/"+paswd+"@//" + aixData;

                databaseConnection = aixUrl;
                dbConnectionWithHost = pwhAixUrl;
            }

//            Differentiate PBD instances
            switch (pbd) {
                case "s2" : pbd_ip = "10.246.89.245:10780"  ; break;
                case "s4" : pbd_ip = "10.246.89.245:10870"  ; break;
                case "s5" : pbd_ip = "10.246.89.245:10880"  ; break;
                case "s6" : pbd_ip = "139.114.216.245:10850"; break;
                case "a4" : pbd_ip = "139.114.216.245:12340"; break;
                case "n1" : pbd_ip = "10.246.89.245:11230"  ; break;
                case "d6" :
                default : pbd_ip = "10.246.89.108:20891";
            }

//            Differentiate CORE instances
            switch (core) {
                case "s2"   : core_ip = "10.246.89.245:10700"   ; break;
                case "u"    : core_ip = "139.114.216.245:10730" ; break;
                case "c"    : core_ip = "139.114.216.245:13020" ; break;
                case "a"    : core_ip = "139.114.216.245:10120" ; break;
                case "s3"   :
                default : core_ip = "10.246.89.245:10710";
            }

//            Construct Return Values
            list[0] = env;
            list[1] = eos_ip;
            list[2] = ebs_ip;
            list[3] = databaseConnection;
            list[4] = dbConnectionWithHost;
            list[5] = pbd_ip;
            list[6] = ftsOnline;
            list[7] = ftsBatch;
            list[8] = core_ip;
            list[9] = mq_send;
            list[10] = mq_recieve;
            list[11] = mQHostName;
            list[12] = mQPort;
            list[13] = mqQueueManager;
            list[14] = mQChannelAuth;
        } else {
            for (int i=0 ; i< list.length ; i++)
                list[i] = null;
        }
        return list;
    }
}