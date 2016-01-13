import java.util.ArrayList;

public class LanguageFamilyNode
{
	private String name;
	private ArrayList<LanguageFamilyNode> children;    

	public LanguageFamilyNode(String name)
	{
		this.name = name;
		this.children = new ArrayList<LanguageFamilyNode>();
	}

	public String getName()
	{
		return name;
	}
	public ArrayList<LanguageFamilyNode> getChildren()
	{
		return children;
	}
	public void addChildren(LanguageFamilyNode inboundChildren)
	{
		this.children.add(inboundChildren);
	}

	public static void main(String[] args) 
	{
		LanguageFamilyNode sinoTibetan = new LanguageFamilyNode("Sino-Tibetan");
		LanguageFamilyNode chinese = new LanguageFamilyNode("Chinese");
		LanguageFamilyNode middleChinese = new LanguageFamilyNode("Middle Chinese");
		LanguageFamilyNode oldWuMin = new LanguageFamilyNode("Old Wu-Min");
		LanguageFamilyNode oldXia = new LanguageFamilyNode("Old Xia");
		LanguageFamilyNode oldChu = new LanguageFamilyNode("Old Chu");
		LanguageFamilyNode yue = new LanguageFamilyNode("Yue");
		LanguageFamilyNode northern = new LanguageFamilyNode("Northern");
		LanguageFamilyNode mandarin = new LanguageFamilyNode("Mandarin");
		LanguageFamilyNode wu = new LanguageFamilyNode("Wu");
		LanguageFamilyNode min = new LanguageFamilyNode("Min");
		LanguageFamilyNode gan = new LanguageFamilyNode("Gan");
		LanguageFamilyNode xiang = new LanguageFamilyNode("Xiang");
		LanguageFamilyNode cantonese = new LanguageFamilyNode("Cantonese");
		LanguageFamilyNode pinghua = new LanguageFamilyNode("Pinghua");
		LanguageFamilyNode taishanese = new LanguageFamilyNode("Taishanese");
		LanguageFamilyNode minbei = new LanguageFamilyNode("Min Bei");
		LanguageFamilyNode minnan = new LanguageFamilyNode("Min Nan");
		LanguageFamilyNode hokkien = new LanguageFamilyNode("Hokkien");
		LanguageFamilyNode teochiu = new LanguageFamilyNode("Teochiu");
		LanguageFamilyNode northernwu = new LanguageFamilyNode("Northern Wu");
		LanguageFamilyNode southernwu = new LanguageFamilyNode("Southern Wu");
		LanguageFamilyNode shanghainese = new LanguageFamilyNode("Shanhainese");
		LanguageFamilyNode hakka = new LanguageFamilyNode("Hakka");


		sinoTibetan.addChildren(chinese);
		chinese.addChildren(middleChinese);
		chinese.addChildren(oldWuMin);
		chinese.addChildren(oldXia);
		chinese.addChildren(oldChu);
		middleChinese.addChildren(yue);
		middleChinese.addChildren(northern);
		northern.addChildren(mandarin);
		oldWuMin.addChildren(wu);
		oldWuMin.addChildren(min);
		oldChu.addChildren(gan);
		oldChu.addChildren(xiang);
		yue.addChildren(cantonese);
		yue.addChildren(pinghua);
		yue.addChildren(taishanese);
		min.addChildren(minnan);
		min.addChildren(minbei);
		minnan.addChildren(hokkien);
		minnan.addChildren(teochiu);
		wu.addChildren(northernwu);
		wu.addChildren(southernwu);
		southernwu.addChildren(shanghainese);
		gan.addChildren(hakka);

		sinoTibetan.printAllDescendants();
		

	}

	public void printAllDescendants(int depth)
	{
		for (int i = 0; i<depth; i++) 
		{
			System.out.print("  ");	
		}
		System.out.println(this.name);

		if (children.isEmpty()) 
		{
			return; //ends if no children to move on to
		}
		else
		{
			for(int i = 0; i<this.children.size(); i++)
			{
				this.children.get(i).printAllDescendants(depth + 1); //recursive part
			}
		}
	}
	public void printAllDescendants()
	{
		printAllDescendants(0); //stub for the first one
	}
}
