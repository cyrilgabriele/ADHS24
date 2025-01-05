public class CustomNode {
    CustomNode parentNode;
    CustomNode childNodeLeft; 
    CustomNode childNodeRight;

    public CustomNode(CustomNode childNodeLeft, CustomNode childNodeRight) {
        this.childNodeLeft = childNodeLeft; 
        this.childNodeRight = childNodeRight;
    }

    public void setChildNode(CustomNode childNode, int position) {
        if (position == 0) {
            this.childNodeLeft = childNode;
        } else if (position == 1) {
            this.childNodeRight = childNode;
        }
    }
}
