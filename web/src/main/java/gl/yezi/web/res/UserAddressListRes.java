/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.res;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月9日
 */
public class UserAddressListRes extends Res {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @JsonInclude(Include.NON_NULL)
    private Integer offset;
    @JsonInclude(Include.NON_NULL)
    private List<UserAddressRes> addresses;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public List<UserAddressRes> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<UserAddressRes> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(UserAddressRes userAddressRes) {
        if (addresses == null) {
            addresses = new ArrayList<UserAddressRes>();
        }
        addresses.add(userAddressRes);
    }
}
