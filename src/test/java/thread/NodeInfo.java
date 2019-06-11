package thread;

import java.util.List;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 17:45 2019-05-30
 * @Modified By:
 */
public class NodeInfo {


  private List<Integer> pids;

  private List<Integer> cids;

  private String value;

  public List<Integer> getPids() {
    return pids;
  }

  public void setPids(List<Integer> pids) {
    this.pids = pids;
  }

  public List<Integer> getCids() {
    return cids;
  }

  public void setCids(List<Integer> cids) {
    this.cids = cids;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
