package gl.yezi.data.page;

/**
 * User: xiaobinghan Date: 11-7-8 Time: 上午10:39 列表分页信息
 */
public class Pagination {
    private static final int DEFAULTSIZE = 10;
    private static final int HEADNO = 1;

    public Pagination() {
        this(HEADNO, DEFAULTSIZE);
    }

    public Pagination(int no, int size) {
        setSize(size);
        setNo(no);
    }

    private int count;
    private int size;
    private int no;

    /**
     * 元素总数
     * 
     * @return
     */
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count > 0 ? count : 0;
    }

    /**
     * 单页中元素数量
     * 
     * @return
     */
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size > 0 ? size : DEFAULTSIZE;
    }

    /**
     * 当前页码
     * 
     * @return
     */
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no > 1 ? no : HEADNO;
    }

    /**
     * 起始索引位置
     * 
     * @return
     */
    public int getStartIndex() {
        int index = size * (no - 1);
        return index >= 0 ? index : 0;
    }

    /**
     * 结束索引位置 for redis
     * 
     * @return
     */
    public int getEndIndex() {
        int index = size * no;
        index = count <= 0 ? index : (index <= count ? index : count);
        return index - 1;
    }

    /**
     * 首页码
     * 
     * @return
     */
    public int getHeadNo() {
        return HEADNO;
    }

    /**
     * 到首页
     * 
     * @return
     */
    public boolean isHeadNo() {
        return no <= getHeadNo();
    }

    /**
     * 尾页码
     * 
     * @return
     */
    public int getEndNo() {
        return getPageCount();
    }

    /**
     * 到尾页
     * 
     * @return
     */
    public boolean isEndNo() {
        return no >= getEndNo();
    }

    /**
     * 上一页码
     * 
     * @return
     */
    public int getPreNo() {
        return isHeadNo() ? getHeadNo() : no - 1;
    }

    /**
     * 下一页码
     * 
     * @return
     */
    public int getNextNo() {
        return isEndNo() ? getEndNo() : no + 1;
    }

    /**
     * 页数
     * 
     * @return
     */
    public int getPageCount() {
        return count % size == 0 ? count / size : count / size + 1;
    }

    public int getOffset() {
        return getStartIndex();
    }

    public int getLimit() {
        return getSize();
    }

    /**
     * 列表从后往前取, 必须指定count
     * 
     * @return
     */
    public int getRevStartIndex() {
        int index = count - (size * no);
        return index < 0 ? 0 : index;
    }

    /**
     * 列表从后往前取, 必须指定count
     * 
     * @return
     */
    public int getRevEndIndex() {
        int index = count - (size * (no - 1)) - 1;
        return index < 0 ? 0 : index;
    }
}
