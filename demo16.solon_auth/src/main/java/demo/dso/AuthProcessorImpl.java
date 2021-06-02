package demo.dso;

import org.noear.bcf.BcfClient;
import org.noear.solon.core.handle.Context;
import org.noear.solon.extend.auth.AuthProcessor;
import org.noear.solon.extend.auth.annotation.Logical;

/**
 * @author noear 2021/5/28 created
 */
public class AuthProcessorImpl implements AuthProcessor {
    private int puid() {
        return Context.current().session("puid", 0);
    }

    @Override
    public boolean verifyIp() {
        return true;
    }

    @Override
    public boolean verifyLogined() {
        return puid() > 0;
    }

    @Override
    public boolean verifyPath(String path, String method) {
        try {
            if (BcfClient.hasUrlpath(path)) {
                return BcfClient.hasUrlpathByUser(puid(), path);
            } else {
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean verifyPermissions(String[] permissions, Logical logical) {
        int puid = puid();

        try {
            if (logical == Logical.AND) {
                boolean isOk = true;

                for (String p : permissions) {
                    isOk = isOk && BcfClient.hasResourceByUser(puid, p);
                }

                return isOk;
            } else {
                for (String p : permissions) {
                    if (BcfClient.hasResourceByUser(puid, p)) {
                        return true;
                    }
                }
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean verifyRoles(String[] roles, Logical logical) {
        int puid = puid();

        try {
            if (logical == Logical.AND) {
                boolean isOk = true;

                for (String p : roles) {
                    isOk = isOk && BcfClient.isUserInGroup(puid, p);
                }

                return isOk;
            } else {
                for (String p : roles) {
                    if (BcfClient.isUserInGroup(puid, p)) {
                        return true;
                    }
                }
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
