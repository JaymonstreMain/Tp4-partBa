package structures.pile;

public class NoeudPile
{
    NoeudPile precedent;
    private Object element;

    private NoeudPile(Object pElement)
    {
        this(pElement, null);
    }

    NoeudPile(Object pElement, NoeudPile pPrecedent)
    {
        this.element = pElement;
        this.precedent = pPrecedent;
    }

    NoeudPile getPrecedent()
    {
        return this.precedent;
    }

    Object getElement()
    {
        return this.element;
    }
}